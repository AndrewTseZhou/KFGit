package com.andrewtse.kfgit;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.andrewtse.kfgit.di.component.DaggerIApplicationComponent;
import com.andrewtse.kfgit.di.component.IApplicationComponent;
import com.andrewtse.kfgit.di.module.ApplicationModule;

import androidx.multidex.MultiDexApplication;

/**
 * @author xk
 * @date 2019/2/17
 */
public class KFGitApplication extends MultiDexApplication {

    IApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        ///初始化路由
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    public static KFGitApplication get(Context context) {
        return (KFGitApplication) context.getApplicationContext();
    }

    public IApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerIApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        }
        return mApplicationComponent;
    }

    public void setApplicationComponent(IApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
