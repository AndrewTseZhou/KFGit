package com.andrewtse.kfgit.contract;

/**
 * @author xk
 * @date 2019/2/17
 */
public interface BaseContract {
    interface BaseModel {
    }

    interface BaseView {
    }

    interface BasePresenter<V extends BaseView> {
    }
}
