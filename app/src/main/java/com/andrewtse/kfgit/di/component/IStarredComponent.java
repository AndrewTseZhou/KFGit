package com.andrewtse.kfgit.di.component;

import com.andrewtse.kfgit.di.PerActivity;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.StarredModule;
import com.andrewtse.kfgit.ui.module.main.fragment.StarredFragment;

import dagger.Component;

/**
 * @author xk
 * @date 2019/2/19
 */
@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = {ActivityModule.class, StarredModule.class})
public interface IStarredComponent extends IActivityComponent {

    void inject(StarredFragment fragment);
}
