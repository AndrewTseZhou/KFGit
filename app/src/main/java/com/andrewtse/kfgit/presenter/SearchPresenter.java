package com.andrewtse.kfgit.presenter;

import android.app.Application;
import android.util.Log;

import com.andrewtse.kfgit.contract.ISearchContract;
import com.andrewtse.kfgit.data.api.RepoApi;
import com.andrewtse.kfgit.data.net.response.SearchResp;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author xk
 * @date 2019/2/22
 */
public class SearchPresenter extends BasePresenterImpl<ISearchContract.ISearchView> {

    private static final String TAG = "SearchPresenter";

    private final RepoApi mRepoApi;

    @Inject
    Application mContext;

    @Inject
    public SearchPresenter(RepoApi searchRepoApi) {
        mRepoApi = searchRepoApi;
    }

    public void getSearchResult(String q, int page, int perPage, int type) {
        mRepoApi.getSearchResult(q, page, perPage, type)
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
