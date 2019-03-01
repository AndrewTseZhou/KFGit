package com.andrewtse.kfgit.data.net.datasource;

import android.app.Application;

import com.andrewtse.kfgit.data.api.StarredApi;
import com.andrewtse.kfgit.data.net.client.StarredRetrofit;
import com.andrewtse.kfgit.data.net.interf.StarredInterface;
import com.andrewtse.kfgit.model.StarredModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author xk
 * @date 2019/2/19
 */
public class StarredDataSource implements StarredApi {

    @Inject
    StarredRetrofit mStarredRetrofit;

    @Inject
    Application mContext;

    @Inject
    public StarredDataSource() {
    }

    @Override
    public Observable<List<StarredModel>> loadStarred(String token, int page, int perPage) {
        mStarredRetrofit.setQueryParams(token, page);
        StarredInterface starredInterface = mStarredRetrofit.get().create(StarredInterface.class);
        return starredInterface.getStarred(page, perPage);
    }
}
