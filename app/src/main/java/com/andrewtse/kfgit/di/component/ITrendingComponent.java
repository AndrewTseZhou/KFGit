package com.andrewtse.kfgit.di.component;

import com.andrewtse.kfgit.di.PerActivity;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.TrendingModule;
import com.andrewtse.kfgit.ui.module.main.fragment.TrendingFragment;

import dagger.Component;

/**
 * @author xk
 * @date 2019/2/26
 */
@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = {ActivityModule.class, TrendingModule.class})
public interface ITrendingComponent extends IActivityComponent {

    void inject(TrendingFragment fragment);
}
