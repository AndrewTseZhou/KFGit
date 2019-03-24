package com.andrewtse.kfgit.presenter;

import android.app.Application;
import android.util.Log;

import com.andrewtse.kfgit.contract.IRepoDetailInfoContract;
import com.andrewtse.kfgit.data.api.RepoApi;
import com.andrewtse.kfgit.model.RepoDetailInfoModel;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author xk
 * @date 2019/3/17
 */
public class RepoDetailInfoPresenter extends BaseRepoPresenter<IRepoDetailInfoContract.IRepoDetailInfoView> {

    private static final String TAG = "RepoDetailInfoPresenter";

    @Inject
    public RepoDetailInfoPresenter(RepoApi repoApi) {
        super(repoApi);
    }

    public void getRepoDetailInfo(String owner, String repo) {
        mRepoApi.getRepoDetailInfo(owner, repo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getBaseView().showLoading())
                .doOnTerminate(() -> getBaseView().dismissLoading())
                .subscribe(new Observer<RepoDetailInfoModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d);
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(RepoDetailInfoModel repoModel) {
                        Log.d(TAG, "onNext: " + repoModel);
                        getBaseView().showContent(repoModel);
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
