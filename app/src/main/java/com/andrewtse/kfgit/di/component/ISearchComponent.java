package com.andrewtse.kfgit.di.component;

import com.andrewtse.kfgit.di.PerActivity;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.SearchModule;
import com.andrewtse.kfgit.ui.module.main.fragment.SearchFragment;

import dagger.Component;

/**
 * @author xk
 * @date 2019/2/22
 */
@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = {ActivityModule.class, SearchModule.class})
public interface ISearchComponent extends IActivityComponent {

    void inject(SearchFragment fragment);
}
