package com.andrewtse.kfgit.data.net.client;

import android.text.TextUtils;

import com.andrewtse.kfgit.common.utils.ActivityUtils;
import com.andrewtse.kfgit.common.utils.NetworkUtils;
import com.andrewtse.kfgit.data.net.client.base.BaseRetrofit;

import java.io.File;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

    private class StarredHttpClient extends CacheHttpClient {

        private static final long CACHE_SIZE = 50 * 1024 * 1024;

        public StarredHttpClient(String token, int page) {
            mToken = token;
            mPage = page;
        }

        @Override
        protected OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
            if (!TextUtils.isEmpty(mToken)) {
                File cacheFile = new File(ActivityUtils.getTopActivity().getCacheDir(), "github_repo");
                Cache cache = new Cache(cacheFile, CACHE_SIZE);
                builder.cache(cache);
                builder.addNetworkInterceptor(chain -> {
                    Request request = chain.request();

                    if (!NetworkUtils.isConnected()) {
                        request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                    }

                    Response originalResponse = chain.proceed(request);
                    if (NetworkUtils.isConnected()) {
                        String cacheControl = request.cacheControl().toString();
                        return originalResponse.newBuilder().header("Cache-Control", cacheControl).build();
                    } else {
                        return originalResponse.newBuilder().header("Cache-Control", CacheControl.FORCE_CACHE.toString()).build();
                    }
                });

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
