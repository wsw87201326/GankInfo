package com.wsw.gankinfo.di.module;


import com.wsw.gankinfo.BuildConfig;
import com.wsw.gankinfo.net.GankApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
        OkHttpClient httpClient;
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
        } else {
            httpClient = new OkHttpClient();
        }

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build().create(GankApi.class);
    }
}
