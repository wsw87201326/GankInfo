package com.wsw.gankinfo.di.component;

import com.wsw.gankinfo.di.AppScope;
import com.wsw.gankinfo.di.module.DailyModule;
import com.wsw.gankinfo.di.module.RecycleViewModule;
import com.wsw.gankinfo.view.DailyActivity;

import dagger.Component;

@AppScope
@Component(dependencies = AppComponent.class, modules = {DailyModule.class, RecycleViewModule.class})
public interface DailyComponent {

    void inject(DailyActivity dailyActivity);
}
