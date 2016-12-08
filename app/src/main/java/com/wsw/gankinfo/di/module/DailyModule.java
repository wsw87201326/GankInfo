package com.wsw.gankinfo.di.module;


import com.wsw.gankinfo.di.AppScope;

import java.util.Calendar;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wsw on 2016/12/8.
 */
@Module
public class DailyModule {

    @Provides
    @AppScope
    Calendar provideCalendar() {
        return Calendar.getInstance();
    }
}
