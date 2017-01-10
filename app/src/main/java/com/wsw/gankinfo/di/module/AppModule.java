package com.wsw.gankinfo.di.module;

import com.google.gson.Gson;

import android.content.Context;

import java.util.Calendar;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    Calendar provideCalendar() {
        return Calendar.getInstance();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

}
