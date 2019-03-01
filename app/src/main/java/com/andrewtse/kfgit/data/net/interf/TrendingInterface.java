package com.andrewtse.kfgit.data.net.interf;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author xk
 * @date 2019/2/26
 */
public interface TrendingInterface {

    @GET("https://github.com/trending/{languageType}")
    Observable<String> getTrendingRepo(@Path("languageType") String languageType, @Query("since") String since);
}
