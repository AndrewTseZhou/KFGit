package com.andrewtse.kfgit.di.module;

import com.andrewtse.kfgit.data.api.UserApi;
import com.andrewtse.kfgit.data.net.datasource.UserDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * @author xk
 * @date 2019/2/17
 */
@Module
public class UserModule {

    @Provides
    UserApi provideUserApi(UserDataSource dataSource) {
        return dataSource;
    }
}
