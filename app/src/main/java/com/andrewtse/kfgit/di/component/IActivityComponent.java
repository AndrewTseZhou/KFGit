package com.andrewtse.kfgit.di.component;

import android.app.Activity;

import com.andrewtse.kfgit.di.PerActivity;
import com.andrewtse.kfgit.di.module.ActivityModule;

import dagger.Component;

/**
 * @author xk
 * @date 2019/2/17
 */
@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = ActivityModule.class)
public interface IActivityComponent {

    Activity activity();
}
