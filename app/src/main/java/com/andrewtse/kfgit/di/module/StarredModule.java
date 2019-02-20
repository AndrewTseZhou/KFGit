package com.andrewtse.kfgit.di.module;

import com.andrewtse.kfgit.data.api.StarredApi;
import com.andrewtse.kfgit.data.net.datasource.StarredDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * @author xk
 * @date 2019/2/19
 */
@Module
public class StarredModule {

    @Provides
    StarredApi provideStarredApi(StarredDataSource dataSource) {
        return dataSource;
    }
}
