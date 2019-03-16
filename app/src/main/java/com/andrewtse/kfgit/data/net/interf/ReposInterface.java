package com.andrewtse.kfgit.data.net.interf;

import com.andrewtse.kfgit.data.net.response.SearchResp;
import com.andrewtse.kfgit.model.StarredModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author xk
 * @date 2019/3/16
 */
public interface ReposInterface {

    //Trending模块
    @GET("https://github.com/trending/{languageType}")
    Observable<String> getTrendingRepo(@Path("languageType") String languageType, @Query("since") String since);

    //搜索模块
    @GET("/search/repositories")
    Observable<SearchResp> getSearchRepoResult(@Query("q") String q, @Query("page") int page, @Query("per_page") int perPage);

    @GET("/search/users")
    Observable<SearchResp> getSearchUsersResult(@Query("q") String q, @Query("page") int page, @Query("per_page") int perPage);

    //Star模块
    @GET("/user/starred")
    Observable<List<StarredModel>> getStarred(@Query("page") int page, @Query("per_page") int perPage);
}
