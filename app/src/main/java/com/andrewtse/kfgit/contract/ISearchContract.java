package com.andrewtse.kfgit.contract;

import com.andrewtse.kfgit.model.SearchModel;
import com.andrewtse.kfgit.ui.widget.lce.ILceView;

import java.util.List;

/**
 * @author xk
 * @date 2019/2/22
 */
public interface ISearchContract {
    interface ISearchModel extends IBaseContract.IBaseModel {
    }

    interface ISearchView extends ILceView<List<SearchModel>> {
    }

    interface ISearchPresenter extends IBaseContract.IBasePresenter<ISearchView> {
    }
}
