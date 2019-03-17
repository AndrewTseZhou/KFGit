package com.andrewtse.kfgit.data.api;

import com.andrewtse.kfgit.data.net.response.SearchResp;
import com.andrewtse.kfgit.model.StarredModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author xk
 * @date 2019/3/17
 */
public interface RepoApi {

    Observable<String> getTrendingRepo(String languageType, String q);

    Observable<SearchResp> getSearchResult(String q, int page, int perPage, int type);

    Observable<List<StarredModel>> loadMyStarred(String token, int page, int perPage);
}
