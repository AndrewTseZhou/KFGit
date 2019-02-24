package com.andrewtse.kfgit.data.net.client;

import com.andrewtse.kfgit.data.net.client.base.BaseOkHttpClient;
import com.andrewtse.kfgit.data.net.client.base.BaseRetrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * @author xk
 * @date 2019/2/22
 */
public class SearchRetrofit extends BaseRetrofit {

    private String mQueryParams;
    private int mPage;
    private int mPerPage;

    @Inject
    public SearchRetrofit() {
    }

    public void setQueryParams(String q, int page, int perPage) {
        mQueryParams = q;
        mPage = page;
        mPerPage = perPage;
    }

    @Override
    protected OkHttpClient getHttpClient() {
        return new SearchHttpClient(mQueryParams, mPage, mPerPage).get();
    }

    private class SearchHttpClient extends BaseOkHttpClient {

        private String mQueryParams;
        private int mPage;
        private int mPerPage;

        public SearchHttpClient(String queryParams, int page, int perPage) {
            mQueryParams = queryParams;
            mPage = page;
            mPerPage = perPage;
        }

        @Override
        protected OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
            return builder;
        }
    }
}
