package com.andrewtse.kfgit.data.api;

import com.andrewtse.kfgit.model.User;

import io.reactivex.Observable;


/**
 * @author xk
 * @date 2019/2/17
 */
public interface UserApi {

    Observable<User> login(String userName, String password);
}
