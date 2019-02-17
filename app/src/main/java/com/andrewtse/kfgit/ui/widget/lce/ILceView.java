package com.andrewtse.kfgit.ui.widget.lce;

import com.andrewtse.kfgit.contract.IBaseContract;

import androidx.annotation.UiThread;

/**
 * @author xk
 * @date 2019/2/17
 * Loading, Content, Error的View
 */
public interface ILceView<M> extends IBaseContract.IBaseView {

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
