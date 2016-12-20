package com.wsw.gankinfo.di.component;

import com.wsw.gankinfo.di.AppScope;
import com.wsw.gankinfo.view.DatePickerActivity;

import dagger.Component;

/**
 * Created by wsw on 2016/12/20.
 */
@AppScope
@Component(dependencies = AppComponent.class)
public interface DatePickerComponent {
    void inject(DatePickerActivity datePickerActivity);
}
