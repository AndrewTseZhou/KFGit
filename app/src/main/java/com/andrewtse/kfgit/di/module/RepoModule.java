package com.andrewtse.kfgit.di.module;

import com.andrewtse.kfgit.data.api.RepoApi;
import com.andrewtse.kfgit.data.net.datasource.RepoDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * @author xk
 * @date 2019/3/17
 */
@Module
public class RepoModule {

    @Provides
    RepoApi provideRepoApi(RepoDataSource dataSource) {
        return dataSource;
    }
}
