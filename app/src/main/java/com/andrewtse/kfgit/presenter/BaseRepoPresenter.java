package com.andrewtse.kfgit.presenter;

import android.app.Application;

import com.andrewtse.kfgit.contract.IBaseContract;
import com.andrewtse.kfgit.data.api.RepoApi;

import javax.inject.Inject;

/**
 * @author xk
 * @date 2019/3/24
 */
public class BaseRepoPresenter<V extends IBaseContract.IBaseView> extends BasePresenterImpl<V> {

    protected final RepoApi mRepoApi;

    @Inject
    Application mContext;

    @Inject
    public BaseRepoPresenter(RepoApi repoApi) {
        mRepoApi = repoApi;
    }
}
