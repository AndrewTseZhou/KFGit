package com.andrewtse.kfgit.data.api;

import io.reactivex.Observable;

/**
 * @author xk
 * @date 2019/2/26
 */
public interface TrendingApi {

    Observable<String> getTrendingRepo(String languageType, String q);
}
