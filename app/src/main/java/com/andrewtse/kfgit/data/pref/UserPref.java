package com.andrewtse.kfgit.data.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.andrewtse.kfgit.model.User;
import com.andrewtse.kfgit.ui.module.account.LoginActivity;
import com.google.gson.Gson;

/**
 * @author xk
 * @date 2019/2/17
 */
public class UserPref {

    private static final String KEY_LOGIN_TOKEN = "login_token";
    private static final String KEY_LOGIN_USER = "login_user";

    private static SharedPreferences getPreference(Context context) {
        return context.getApplicationContext().getSharedPreferences("com.andrewtse.kfgit.user_preference.xml", Context.MODE_PRIVATE);
    }

    public static void saveLoginToken(Context context, String loginToken) {
        getPreference(context).edit().putString(KEY_LOGIN_TOKEN, loginToken).apply();
    }

    public static String getLoginToken(Context context) {
        return getPreference(context).getString(KEY_LOGIN_TOKEN, "");
    }

    public static void saveLoginUser(Context context, User user) {
        String userJson = new Gson().toJson(user);
        getPreference(context).edit().putString(KEY_LOGIN_USER, userJson).apply();
    }

    public static void removeLoginUser(Context context) {
        getPreference(context).edit().remove(KEY_LOGIN_USER).apply();
    }

    public static User getLoginUser(Context context) {
        User user = null;
        String userJson = getPreference(context).getString(KEY_LOGIN_USER, "");
        if (!TextUtils.isEmpty(userJson)) {
            user = new Gson().fromJson(userJson, User.class);
        }
        return user;
    }

    public static boolean isLogin(Context context) {
        return !TextUtils.isEmpty(getLoginToken(context)) && getLoginUser(context) != null;
    }

    public static boolean checkLogin(Context context) {
        if (!isLogin(context)) {
            LoginActivity.launch(context);
            return false;
        }

        return true;
    }

    public static boolean isSelf(Context context, String username) {
        User user = getLoginUser(context);
        return user != null && !TextUtils.isEmpty(username) && username.equals(user.getLogin());
    }
}
