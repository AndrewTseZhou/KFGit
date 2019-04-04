package com.andrewtse.kfgit.presenter;

import android.util.Log;

import com.andrewtse.kfgit.contract.ISearchContract;
import com.andrewtse.kfgit.data.api.RepoApi;
import com.andrewtse.kfgit.data.net.response.SearchResp;

import java.io.IOException;
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
 * @date 2019/2/22
 */
public class SearchPresenter extends BaseRepoPresenter<ISearchContract.ISearchView> {

    private static final String TAG = "SearchPresenter";

    @Inject
    public SearchPresenter(RepoApi searchRepoApi) {
        super(searchRepoApi);
    }

    public void getSearchResult(String q, int page, int perPage, int type) {
        mRepoApi.getSearchResult(q, page, perPage, type)
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
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getBaseView().showLoading())
                .doOnTerminate(() -> getBaseView().dismissLoading())
                .subscribe(new Observer<SearchResp>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d);
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(SearchResp searchModels) {
                        Log.d(TAG, "onNext: " + searchModels);
                        getBaseView().showContent(searchModels.getItems());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}
