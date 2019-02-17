package com.andrewtse.kfgit.di.module;

import android.app.Application;
import android.content.Context;

import com.andrewtse.kfgit.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * @author xk
 * @date 2019/2/17
 */
@Module
public class ApplicationModule {

    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }
}
