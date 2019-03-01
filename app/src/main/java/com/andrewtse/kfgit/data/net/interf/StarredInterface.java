package com.andrewtse.kfgit.data.net.interf;

import com.andrewtse.kfgit.model.StarredModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author xk
 * @date 2019/2/19
 */
public interface StarredInterface {

    @GET("/user/starred")
    Observable<List<StarredModel>> getStarred(@Query("page") int page, @Query("per_page") int perPage);
}
