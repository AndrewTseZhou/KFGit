package com.andrewtse.kfgit.data.net.datasource;

import android.app.Application;

import com.andrewtse.kfgit.common.config.ConfigInfo;
import com.andrewtse.kfgit.data.api.UserApi;
import com.andrewtse.kfgit.data.net.client.AuthRetrofit;
import com.andrewtse.kfgit.data.net.interf.UserInterface;
import com.andrewtse.kfgit.data.net.request.CreateAuthorization;
import com.andrewtse.kfgit.data.net.response.AuthorizationResp;
import com.andrewtse.kfgit.data.pref.UserPref;
import com.andrewtse.kfgit.model.User;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * @author xk
 * @date 2019/2/17
 */
public class UserDataSource implements UserApi {

    @Inject
    AuthRetrofit mAuthRetrofit;

    @Inject
    Application mContext;

    @Inject
    public UserDataSource() {
    }

    @Override
    public Observable<User> login(String userName, String password) {
        mAuthRetrofit.setAuthInfo(userName, password);
        UserInterface userInterface = mAuthRetrofit.get().create(UserInterface.class);

        CreateAuthorization createAuthorization = new CreateAuthorization();
        createAuthorization.client_id = ConfigInfo.CLIENT_ID;
        createAuthorization.client_secret = ConfigInfo.CLIENT_SECRET;
        createAuthorization.scopes = ConfigInfo.SCOPES;
        createAuthorization.note = ConfigInfo.NOTE;

        return userInterface.createAuthorization(createAuthorization)
                            .flatMap((Function<AuthorizationResp, ObservableSource<User>>) authorizationResp -> {
                                String token = authorizationResp.getToken();
                                UserPref.saveLoginToken(mContext, token);
                                return userInterface.getUserInfo(token);
                            });
    }
}
