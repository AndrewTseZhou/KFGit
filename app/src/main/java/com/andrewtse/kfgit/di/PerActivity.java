package com.andrewtse.kfgit.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author xk
 * @date 2019/2/17
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
