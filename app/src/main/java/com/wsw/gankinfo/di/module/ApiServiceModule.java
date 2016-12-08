package com.wsw.gankinfo.di.module;


import com.wsw.gankinfo.net.GankApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 提供APIServer的类 Create By :wsw 2016-12-06 21:31
 */
@Module
public class ApiServiceModule {
    private static final String BASE_URL = "http://gank.io/api/";

    // Retrofit 2.0的请求
    @Provides
    @Singleton
    GankApi provideGankApi() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(GankApi.class);
    }
}
