package com.andrewtse.kfgit.data.net.client;

import com.andrewtse.kfgit.data.net.client.base.BaseRetrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * @author xk
 * @date 2019/2/22
 */
public class SearchRetrofit extends BaseRetrofit {

    CacheHttpClient mCacheHttpClient;

    @Inject
    public SearchRetrofit(CacheHttpClient client) {
        mCacheHttpClient = client;
    }

    @Override
    protected OkHttpClient getHttpClient() {
        return mCacheHttpClient.get();
    }
}
