package com.andrewtse.kfgit.data.net.client;

import android.text.TextUtils;

import com.andrewtse.kfgit.data.net.client.base.BaseOkHttpClient;
import com.andrewtse.kfgit.data.net.client.base.BaseRetrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author xk
 * @date 2019/2/19
 */
public class StarredRetrofit extends BaseRetrofit {

    private String mToken;
    private int mPage;

    @Inject
    public StarredRetrofit() {
    }

    public void setQueryParams(String token, int page) {
        mToken = token;
        mPage = page;
    }

    @Override
    protected OkHttpClient getHttpClient() {
        return new StarredHttpClient(mToken, mPage).get();
    }

    private class StarredHttpClient extends BaseOkHttpClient {

        private String mToken;
        private int mPage;

        public StarredHttpClient(String token, int page) {
            mToken = token;
            mPage = page;
        }

        @Override
        protected OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
            if (!TextUtils.isEmpty(mToken)) {
                builder.addInterceptor(chain -> {
                    Request originalRequest = chain.request();
                    Request newRequest = originalRequest.newBuilder().header("Authorization", "token " + mToken.trim()).build();
                    return chain.proceed(newRequest);
                });
            }
            return builder;
        }
    }
}
