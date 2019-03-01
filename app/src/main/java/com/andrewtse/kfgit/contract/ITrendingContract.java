package com.andrewtse.kfgit.contract;

import com.andrewtse.kfgit.model.TrendingModel;
import com.andrewtse.kfgit.ui.widget.lce.ILceView;

import java.util.List;

/**
 * @author xk
 * @date 2019/2/26
 */
public interface ITrendingContract {
    interface ITrendingModel extends IBaseContract.IBaseModel {
    }

    interface ITrendingView extends ILceView<List<TrendingModel>> {
    }

    interface ITrendingPresenter extends IBaseContract.IBasePresenter<ITrendingView> {
    }
}
