package com.andrewtse.kfgit.contract;

import androidx.annotation.UiThread;

/**
 * @author xk
 * @date 2019/2/17
 */
public interface IBaseContract {
    interface IBaseModel {
    }

    interface IBaseView {
    }

    interface IBasePresenter<V extends IBaseView> {
        @UiThread
        void attachView(V view);

        @UiThread
        void detachView();
    }
}
