package com.andrewtse.kfgit.ui.widget.lce;

import com.andrewtse.kfgit.contract.IBaseContract;

import androidx.annotation.UiThread;

/**
 * @author xk
 * @date 2019/2/17
 */
public interface ILoadView extends IBaseContract.IBaseView {

    @UiThread
    void showLoading();

    @UiThread
    void dismissLoading();

    @UiThread
    void error(Throwable e);
}
