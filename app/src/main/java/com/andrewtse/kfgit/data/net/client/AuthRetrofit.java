package com.andrewtse.kfgit.data.net.client;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import com.andrewtse.kfgit.data.net.client.base.BaseOkHttpClient;
import com.andrewtse.kfgit.data.net.client.base.BaseRetrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author xk
 * @date 2019/2/17
 */
public class AuthRetrofit extends BaseRetrofit {

    private static final String TAG = "AuthRetrofit";

    private String mUserName;
    private String mPassword;

    @Inject
    public AuthRetrofit() {
    }

    public void setAuthInfo(String userName, String password) {
        mUserName = userName;
        mPassword = password;
    }

    @Override
    protected OkHttpClient getHttpClient() {
        return new AuthHttpClient(mUserName, mPassword).get();
    }

    private class AuthHttpClient extends BaseOkHttpClient {

        private String mUserName;
        private String mPassword;

        public AuthHttpClient(String username, String password) {
            mUserName = username;
            mPassword = password;
        }

        @Override
        protected OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
            if (!TextUtils.isEmpty(mUserName) && !TextUtils.isEmpty(mPassword)) {
                builder.addInterceptor(chain -> {
                    String user = mUserName + ":" + mPassword;
                    Log.d(TAG, "customize: original info = " + user);
                    String basicAuth = "Basic " + new String(Base64.encode(user.getBytes(), Base64.DEFAULT));
                    Log.d(TAG, "customize: basicAuth = " + basicAuth);

                    Request originalRequest = chain.request();
                    Request newRequest = originalRequest.newBuilder().header("Authorization", basicAuth.trim()).build();
                    return chain.proceed(newRequest);
                });
            }
            return builder;
        }
    }
}
