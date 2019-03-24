package com.andrewtse.kfgit.data.net.interf;

import com.andrewtse.kfgit.data.net.response.SearchResp;
import com.andrewtse.kfgit.model.RepoDetailInfoModel;
import com.andrewtse.kfgit.model.StarredModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author xk
 * @date 2019/3/16
 */
public interface ReposInterface {

    //Trending模块
    @Headers("Cache-Control: public, max-age=3600")
    @GET("https://github.com/trending/{languageType}")
    Observable<String> getTrendingRepo(@Path("languageType") String languageType, @Query("since") String since);

    //搜索模块
    @Headers("Cache-Control: public, max-age=3600")
    @GET("/search/repositories")
    Observable<SearchResp> getSearchRepoResult(@Query("q") String q, @Query("page") int page, @Query("per_page") int perPage);

    @Headers("Cache-Control: public, max-age=3600")
    @GET("/search/users")
    Observable<SearchResp> getSearchUsersResult(@Query("q") String q, @Query("page") int page, @Query("per_page") int perPage);

    //Star模块
    @Headers("Cache-Control: public, max-age=600")
    @GET("/user/starred")
    Observable<List<StarredModel>> getMyStarred(@Query("page") int page, @Query("per_page") int perPage);

    //获取仓库信息
    @Headers("Cache-Control: public, max-age=3600")
    @GET("repos/{owner}/{repo}")
    Observable<RepoDetailInfoModel> getRepoDetailInfo(@Path("owner") String owner, @Path("repo") String repo);
}
