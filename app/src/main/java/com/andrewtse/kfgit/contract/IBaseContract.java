package com.andrewtse.kfgit.contract;

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
    }
}
