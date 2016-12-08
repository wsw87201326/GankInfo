package com.wsw.gankinfo.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wsw.gankinfo.GankInfoApp;
import com.wsw.gankinfo.di.component.AppComponent;

/**
 * Create By :wsw
 * 2016-12-06 21:39
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    protected T b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(GankInfoApp.get(this).getAppComponent());
        bindViews();
        beforeSetViews();
        setViews();
        doTransaction();//开始事务
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    @LayoutRes
    protected abstract int getLayoutResId();

    protected void bindViews() {
        b = DataBindingUtil.setContentView(this, getLayoutResId());
    }

    protected abstract void beforeSetViews();

    protected abstract void setViews();

    protected abstract void doTransaction();
}
