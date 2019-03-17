package com.andrewtse.kfgit.di.component;

import com.andrewtse.kfgit.di.PerActivity;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.RepoModule;
import com.andrewtse.kfgit.ui.module.main.fragment.SearchFragment;
import com.andrewtse.kfgit.ui.module.main.fragment.StarredFragment;
import com.andrewtse.kfgit.ui.module.main.fragment.TrendingFragment;

import dagger.Component;

/**
 * @author xk
 * @date 2019/3/17
 */
@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = {ActivityModule.class, RepoModule.class})
public interface IRepoComponent extends IActivityComponent {

    void inject(TrendingFragment fragment);

    void inject(SearchFragment fragment);

    void inject(StarredFragment fragment);
}
