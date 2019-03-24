package com.andrewtse.kfgit.data.net.datasource;

import android.app.Application;

import com.andrewtse.kfgit.data.api.RepoApi;
import com.andrewtse.kfgit.data.net.client.RepoRetrofit;
import com.andrewtse.kfgit.data.net.client.StarredRetrofit;
import com.andrewtse.kfgit.data.net.interf.ReposInterface;
import com.andrewtse.kfgit.data.net.response.SearchResp;
import com.andrewtse.kfgit.model.RepoDetailInfoModel;
import com.andrewtse.kfgit.model.StarredModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author xk
 * @date 2019/3/17
 */
public class RepoDataSource implements RepoApi {

    @Inject
    RepoRetrofit mRetrofit;

    @Inject
    StarredRetrofit mStarredRetrofit;

    @Inject
    Application mContext;

    public static final int SEARCH_REPOS = 1;
    public static final int SEARCH_USERS = 2;

    @Inject
    public RepoDataSource() {
    }

    private ReposInterface getInterfaceInstance() {
        return mRetrofit.get().create(ReposInterface.class);
    }

    @Override
    public Observable<String> getTrendingRepo(String languageType, String q) {
        return getInterfaceInstance().getTrendingRepo(languageType, q);
    }

    @Override
    public Observable<SearchResp> getSearchResult(String q, int page, int perPage, int type) {
        if (type == SEARCH_REPOS) {
            return getInterfaceInstance().getSearchRepoResult(q, page, perPage);
        } else {
            return getInterfaceInstance().getSearchUsersResult(q, page, perPage);
        }
    }

    @Override
    public Observable<List<StarredModel>> loadMyStarred(String token, int page, int perPage) {
        mStarredRetrofit.setQueryParams(token, page);
        ReposInterface starredInterface = mStarredRetrofit.get().create(ReposInterface.class);
        return starredInterface.getMyStarred(page, perPage);
    }

    @Override
    public Observable<RepoDetailInfoModel> getRepoDetailInfo(String owner, String repo) {
        return getInterfaceInstance().getRepoDetailInfo(owner, repo);
    }
}
