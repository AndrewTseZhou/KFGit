package com.andrewtse.kfgit.data.net.datasource;

import android.app.Application;

import com.andrewtse.kfgit.data.api.SearchApi;
import com.andrewtse.kfgit.data.net.client.SearchRetrofit;
import com.andrewtse.kfgit.data.net.interf.SearchInterface;
import com.andrewtse.kfgit.data.net.response.SearchResp;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author xk
 * @date 2019/2/22
 */
public class SearchDataSource implements SearchApi {

    @Inject
    SearchRetrofit mSearchRetrofit;

    @Inject
    Application mContext;

    public static final int SEARCH_REPOS = 1;
    public static final int SEARCH_USERS = 2;

    @Inject
    public SearchDataSource() {
    }

    @Override
    public Observable<SearchResp> getSearchResult(String q, int page, int perPage, int type) {
        mSearchRetrofit.setQueryParams(q, page, perPage);
        SearchInterface searchInterface = mSearchRetrofit.get().create(SearchInterface.class);
        if (type == SEARCH_REPOS) {
            return searchInterface.getSearchRepoResult(q, page, perPage);
        } else {
            return searchInterface.getSearchUsersResult(q, page, perPage);
        }
    }
}
