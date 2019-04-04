package com.andrewtse.kfgit.presenter;

import android.util.Log;

import com.andrewtse.kfgit.contract.IStarredContract;
import com.andrewtse.kfgit.data.api.RepoApi;
import com.andrewtse.kfgit.model.StarredModel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author xk
 * @date 2019/2/19
 */
public class StarredPresenter extends BaseRepoPresenter<IStarredContract.IStarredView> {

    private static final String TAG = "StarredPresenter";

    @Inject
    public StarredPresenter(RepoApi starredApi) {
        super(starredApi);
    }

    public void loadMyStarred(String token, int page, int perPage) {
        mRepoApi.loadMyStarred(token, page, perPage)
                .retryWhen(throwableObservable -> throwableObservable.flatMap((Function<Throwable, ObservableSource<?>>) throwable -> {
                    Log.d(TAG, "apply: throwable: " + throwable.toString());
                    if (throwable instanceof IOException) {
                        if (mCurrentRetryCount < mMaxConnectCount) {
                            mCurrentRetryCount++;
                            mWaitRetryTime = 1000 + mCurrentRetryCount * 1000;
                            Log.d(TAG, "apply: mCurrentRetryCount = " + mCurrentRetryCount + ", mWaitRetryTime = " + mWaitRetryTime);
                            return Observable.just(1).delay(mWaitRetryTime, TimeUnit.MILLISECONDS);
                        } else {
                            Log.d(TAG, "apply: 重试次数已超过设置次数");
                            return Observable.error(new Throwable("开小差了"));
                        }
                    } else {
                        Log.d(TAG, "apply: 发生了非IO异常");
                        return Observable.error(new Throwable("开小差了"));
                    }
                }))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getBaseView().showLoading())
                .doOnTerminate(() -> getBaseView().dismissLoading())
                .subscribe(new Observer<List<StarredModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d);
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(List<StarredModel> starredModels) {
                        Log.d(TAG, "onNext: " + starredModels);
                        getBaseView().showContent(starredModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                        getBaseView().showError(e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}
