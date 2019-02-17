package com.andrewtse.kfgit.di.component;

import android.app.Application;
import android.content.Context;

import com.andrewtse.kfgit.di.ApplicationContext;
import com.andrewtse.kfgit.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author xk
 * @date 2019/2/17
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface IApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();
}
