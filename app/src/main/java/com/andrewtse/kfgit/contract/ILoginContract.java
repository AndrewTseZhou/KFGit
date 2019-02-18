package com.andrewtse.kfgit.contract;

import com.andrewtse.kfgit.model.User;
import com.andrewtse.kfgit.ui.widget.lce.ILoadView;

/**
 * @author xk
 * @date 2019/2/17
 */
public interface ILoginContract {
    interface IUser extends IBaseContract.IBaseModel {
    }

    interface ILoginView extends ILoadView {
        void loginSuccess(User user);
    }

    interface ILoginPresenter extends IBaseContract.IBasePresenter<ILoginView> {
    }
}
