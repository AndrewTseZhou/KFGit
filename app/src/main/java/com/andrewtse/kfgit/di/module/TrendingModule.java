package com.andrewtse.kfgit.di.module;

import com.andrewtse.kfgit.data.api.TrendingApi;
import com.andrewtse.kfgit.data.net.datasource.TrendingDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * @author xk
 * @date 2019/2/26
 */
@Module
public class TrendingModule {

    @Provides
    TrendingApi provideTrendingApi(TrendingDataSource dataSource) {
        return dataSource;
    }
}
