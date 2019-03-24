package com.andrewtse.kfgit.data.net.interf;

import com.andrewtse.kfgit.data.net.request.CreateAuthorization;
import com.andrewtse.kfgit.data.net.response.AuthorizationResp;
import com.andrewtse.kfgit.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author xk
 * @date 2019/2/17
 */
public interface UserInterface {

    @POST("/authorizations")
    Observable<AuthorizationResp> createAuthorization(@Body CreateAuthorization createAuthorization);

    @GET("/user")
    Observable<User> getUserInfo(@Query("access_token") String accessToken);

    @Headers("Cache-Control: public, max-age=3600")
    @GET("/user/following")
    Observable<List<User>> getMyFollowing();

    @Headers("Cache-Control: public, max-age=3600")
    @GET("/users/{user}/following")
    Observable<List<User>> getUserFollowing(@Path("user") String user);

    @Headers("Cache-Control: public, max-age=3600")
    @GET("/user/followers")
    Observable<List<User>> getMyFollowers();

    @Headers("Cache-Control: public, max-age=3600")
    @GET("/users/{user}/followers")
    Observable<List<User>> getUserFollowers(@Path("user") String user);
}
