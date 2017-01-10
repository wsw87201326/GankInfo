package com.wsw.gankinfo.di.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.wsw.gankinfo.di.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * 主要提供RecycleView所需要的部件 Created by wsw on 2016/12/15.
 */
@Module
public class RecycleViewModule {
    private final Context mContext;

    public RecycleViewModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @AppScope
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
    }
}
