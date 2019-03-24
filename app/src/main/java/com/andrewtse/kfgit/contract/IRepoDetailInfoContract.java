package com.andrewtse.kfgit.contract;

import com.andrewtse.kfgit.model.RepoDetailInfoModel;
import com.andrewtse.kfgit.ui.widget.lce.ILceView;

/**
 * @author xk
 * @date 2019/3/17
 */
public interface IRepoDetailInfoContract {
    interface IRepoDetailInfoModel extends IBaseContract.IBaseModel {
    }

    interface IRepoDetailInfoView extends ILceView<RepoDetailInfoModel> {
    }

    interface IRepoDetailInfoPresenter extends IBaseContract.IBasePresenter<IRepoDetailInfoView> {
    }
}
