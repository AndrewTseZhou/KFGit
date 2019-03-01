package com.andrewtse.kfgit.di.component;

import com.andrewtse.kfgit.di.PerActivity;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.UserModule;
import com.andrewtse.kfgit.ui.module.account.LoginActivity;
import com.andrewtse.kfgit.ui.module.main.fragment.ProfileFragment;

import dagger.Component;

/**
 * @author xk
 * @date 2019/2/17
 */
@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface IUserComponent extends IActivityComponent {
    void inject(LoginActivity loginActivity);

    void inject(ProfileFragment fragment);
}
