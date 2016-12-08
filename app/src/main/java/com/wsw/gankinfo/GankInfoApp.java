package com.wsw.gankinfo;

import android.app.Application;
import android.content.Context;

import com.wsw.gankinfo.di.component.AppComponent;
import com.wsw.gankinfo.di.component.DaggerAppComponent;
import com.wsw.gankinfo.di.module.ApiServiceModule;
import com.wsw.gankinfo.di.module.AppModule;

/**
 * Created by wsw on 2016/12/6.
 */

public class GankInfoApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .build();
    }

    public static GankInfoApp get(Context context) {
        return (GankInfoApp) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
