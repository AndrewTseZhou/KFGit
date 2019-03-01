package com.andrewtse.kfgit.data.net.client.base;

import com.andrewtse.kfgit.data.net.constant.ServerConstant;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author xk
 * @date 2019/2/17
 */
public abstract class BaseRetrofit {

    public Retrofit get() {
        return new Retrofit.Builder().baseUrl(ServerConstant.BASE_URL)
                                     .client(getHttpClient())
                                     .addConverterFactory(ScalarsConverterFactory.create())
                                     .addConverterFactory(GsonConverterFactory.create())
                                     .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                     .build();
    }

    protected abstract OkHttpClient getHttpClient();
}
