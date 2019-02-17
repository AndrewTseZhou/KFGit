package com.andrewtse.kfgit;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author xk
 * @date 2019/2/17
 */
public class KFGitApplication extends Application {

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
}
