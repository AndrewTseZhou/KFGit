package com.andrewtse.kfgit.data.net.interf;

import com.andrewtse.kfgit.data.net.response.SearchResp;
import com.andrewtse.kfgit.model.BaseRepoModel;
import com.andrewtse.kfgit.model.RepoDetailInfoModel;
import com.andrewtse.kfgit.model.StarredModel;
import com.andrewtse.kfgit.model.User;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
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

    @Headers("Cache-Control: public, max-age=600")
    @GET("users/{name}/starred")
    Observable<List<StarredModel>> getUserStarredRepos(@Path("name") String user);

    //获取一个仓库的所有贡献者
    @Headers("Cache-Control: public, max-age=3600")
    @GET("repos/{owner}/{name}/contributors")
    Observable<List<User>> getContributors(@Path("owner") String owner, @Path("name") String repo);

    //获取我的所有仓库
    @Headers("Cache-Control: public, max-age=600")
    @GET("user/repos")
    Observable<List<BaseRepoModel>> getMyRepos(@Query("type") String type);

    //获取某个用户所有的仓库
    @Headers("Cache-Control: public, max-age=600")
    @GET("users/{name}/repos")
    Observable<List<BaseRepoModel>> getUserRepos(@Path("name") String user);

    //Star一个仓库
    @Headers("Content-Length: 0")
    @PUT("/user/starred/{owner}/{repo}")
    Observable<Response<ResponseBody>> starRepo(@Path("owner") String owner, @Path("repo") String repo);

    //UnStar一个仓库
    @DELETE("/user/starred/{owner}/{repo}")
    Observable<Response<ResponseBody>> unstarRepo(@Path("owner") String owner, @Path("repo") String repo);

    //检查一个仓库是否被star
    @GET("/user/starred/{owner}/{repo}")
    Observable<Response<ResponseBody>> checkIfRepoIsStarred(@Path("owner") String owner, @Path("repo") String repo);
}
