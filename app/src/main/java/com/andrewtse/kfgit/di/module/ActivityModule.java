package com.andrewtse.kfgit.di.module;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import dagger.Module;
import dagger.Provides;

/**
 * @author xk
 * @date 2019/2/17
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    public ActivityModule(Fragment fragment) {
        mActivity = fragment.getActivity();
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    Context providesContext() {
        return mActivity;
    }
}
