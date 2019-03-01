package com.andrewtse.kfgit.data.net.datasource;

import android.app.Application;

import com.andrewtse.kfgit.data.api.TrendingApi;
import com.andrewtse.kfgit.data.net.client.TrendingRetrofit;
import com.andrewtse.kfgit.data.net.interf.TrendingInterface;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author xk
 * @date 2019/2/26
 */
public class TrendingDataSource implements TrendingApi {

    @Inject
    TrendingRetrofit mTrendingRetrofit;

    @Inject
    Application mContext;

    @Inject
    public TrendingDataSource() {
    }

    @Override
    public Observable<String> getTrendingRepo(String languageType, String q) {
        TrendingInterface trendingInterface = mTrendingRetrofit.get().create(TrendingInterface.class);
        return trendingInterface.getTrendingRepo(languageType, q);
    }
}
