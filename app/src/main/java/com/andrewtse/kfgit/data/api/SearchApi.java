package com.andrewtse.kfgit.data.api;

import com.andrewtse.kfgit.data.net.response.SearchResp;

import io.reactivex.Observable;

/**
 * @author xk
 * @date 2019/2/22
 */
public interface SearchApi {

    Observable<SearchResp> getSearchResult(String q, int page, int perPage, int type);
}
