package com.andrewtse.kfgit.presenter;

import android.app.Application;
import android.util.Log;

import com.andrewtse.kfgit.contract.IStarredContract;
import com.andrewtse.kfgit.data.api.StarredApi;
import com.andrewtse.kfgit.model.StarredModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author xk
 * @date 2019/2/19
 */
public class StarredPresenter extends BasePresenterImpl<IStarredContract.IStarredView> {

    private static final String TAG = "StarredPresenter";

    private final StarredApi mStarredApi;

    @Inject
    Application mContext;

    @Inject
    public StarredPresenter(StarredApi starredApi) {
        mStarredApi = starredApi;
    }

    public void loadStarsRepo(String token, int page) {
        mStarredApi.loadStarred(token, page)
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
