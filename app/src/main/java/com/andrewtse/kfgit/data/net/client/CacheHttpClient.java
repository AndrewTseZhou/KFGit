package com.andrewtse.kfgit.data.net.client;

import android.app.Application;

import com.andrewtse.kfgit.common.utils.NetworkUtils;
import com.andrewtse.kfgit.data.net.client.base.BaseOkHttpClient;

import java.io.File;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author xk
 * @date 2019/3/1
 */
public class CacheHttpClient extends BaseOkHttpClient {

    private static final long CACHE_SIZE = 50 * 1024 * 1024;

    @Inject
    Application mContext;

    @Inject
    public CacheHttpClient() {
    }

    @Override
    protected OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
        File cacheFile = new File(mContext.getCacheDir(), "github_repo");
        Cache cache = new Cache(cacheFile, CACHE_SIZE);
        builder.cache(cache);
        builder.addNetworkInterceptor(mCacheControlInterceptor);
        return builder;
    }

    private final Interceptor mCacheControlInterceptor = chain -> {
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
    };
}
