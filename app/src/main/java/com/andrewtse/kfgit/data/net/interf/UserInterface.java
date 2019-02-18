package com.andrewtse.kfgit.data.net.interf;

import com.andrewtse.kfgit.data.net.request.CreateAuthorization;
import com.andrewtse.kfgit.data.net.response.AuthorizationResp;
import com.andrewtse.kfgit.model.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
}
