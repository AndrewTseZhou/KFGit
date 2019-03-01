package com.andrewtse.kfgit.data.net.client;

import com.andrewtse.kfgit.data.net.client.base.BaseOkHttpClient;
import com.andrewtse.kfgit.data.net.client.base.BaseRetrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * @author xk
 * @date 2019/2/26
 */
public class TrendingRetrofit extends BaseRetrofit {

    private String mLanguageType;
    private String mQueryParams;

    @Inject
    public TrendingRetrofit() {
    }

    public void setQueryParams(String languageType, String q) {
        mLanguageType = languageType;
        mQueryParams = q;
    }

    @Override
    protected OkHttpClient getHttpClient() {
        return new TrendingHttpClient(mLanguageType, mQueryParams).get();
    }

    private class TrendingHttpClient extends BaseOkHttpClient {

        private String mLanguageType;
        private String mQueryParams;

        public TrendingHttpClient(String languageType, String queryParams) {
            mLanguageType = languageType;
            mQueryParams = queryParams;
        }

        @Override
        protected OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
            return builder;
        }
    }
}
