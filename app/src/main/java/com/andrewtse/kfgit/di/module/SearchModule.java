package com.andrewtse.kfgit.di.module;

import com.andrewtse.kfgit.data.api.SearchApi;
import com.andrewtse.kfgit.data.net.datasource.SearchDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * @author xk
 * @date 2019/2/22
 */
@Module
public class SearchModule {

    @Provides
    SearchApi provideSearchApi(SearchDataSource dataSource) {
        return dataSource;
    }
}
