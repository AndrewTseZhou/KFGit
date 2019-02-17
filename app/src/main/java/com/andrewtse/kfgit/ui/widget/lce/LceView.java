package com.andrewtse.kfgit.ui.widget.lce;

import com.andrewtse.kfgit.contract.BaseContract;

import androidx.annotation.UiThread;

/**
 * @author xk
 * @date 2019/2/17
 * Loading, Content, Error的View
 */
public interface LceView<M> extends BaseContract.BaseView {

    @UiThread
    public void showLoading();

    @UiThread
    public void dismissLoading();

    @UiThread
    public void showContent(M data);

    @UiThread
    public void showError(Throwable e);

    @UiThread
    public void showEmpty();
}
