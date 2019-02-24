package com.andrewtse.kfgit.data.net.interf;

import com.andrewtse.kfgit.data.net.response.SearchResp;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author xk
 * @date 2019/2/22
 */
public interface SearchInterface {

    @GET("/search/repositories")
    Observable<SearchResp> getSearchRepoResult(@Query("q") String q, @Query("page") int page, @Query("per_page") int perPage);

    @GET("/search/users")
    Observable<SearchResp> getSearchUsersResult(@Query("q") String q, @Query("page") int page, @Query("per_page") int perPage);
}
