package com.andrewtse.kfgit.data.api;

import com.andrewtse.kfgit.model.StarredModel;

import java.util.List;

import io.reactivex.Observable;


/**
 * @author xk
 * @date 2019/2/19
 */
public interface StarredApi {

    Observable<List<StarredModel>> loadStarred(String token, int page);
}
