package com.andrewtse.kfgit.contract;

import com.andrewtse.kfgit.ui.entity.StarredItem;
import com.andrewtse.kfgit.ui.widget.lce.ILceView;

import java.util.List;

/**
 * @author xk
 * @date 2019/2/19
 */
public interface IStarredContract {
    interface IStarredModel extends IBaseContract.IBaseModel {
    }

    interface IStarredView extends ILceView<List<StarredItem>> {
    }

    interface IStarredPresenter extends IBaseContract.IBasePresenter<IStarredView> {
    }
}
