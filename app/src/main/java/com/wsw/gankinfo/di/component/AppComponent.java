package com.wsw.gankinfo.di.component;

import com.google.gson.Gson;

import android.content.Context;

import com.wsw.gankinfo.GankInfoApp;
import com.wsw.gankinfo.di.module.ApiServiceModule;
import com.wsw.gankinfo.di.module.AppModule;
import com.wsw.gankinfo.di.module.CacheServiceModule;
import com.wsw.gankinfo.net.GankApi;
import com.wsw.gankinfo.utils.DbUtils;

import java.util.Calendar;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class, CacheServiceModule.class})
public interface AppComponent {

    void inject(GankInfoApp gankInfoApp);

    GankApi gankApi();

    Context context();

    Calendar calendar();

    DbUtils dbUtils();

    Gson gson();
}
