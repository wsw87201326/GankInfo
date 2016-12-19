package com.wsw.gankinfo.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.KeyEvent;

import com.wsw.gankinfo.R;
import com.wsw.gankinfo.databinding.ActivityDetailBinding;
import com.wsw.gankinfo.di.component.AppComponent;

public class DetailActivity extends BaseActivity<ActivityDetailBinding> {

    private String url = "";

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void beforeSetViews() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void setViews() {
        b.webView.getSettings().setJavaScriptEnabled(true);
        b.webView.getSettings().setLoadsImagesAutomatically(true);
    }

    @Override
    protected void doTransaction() {
        b.webView.loadUrl(url);
    }

    // To handle the back button key press
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && b.webView.canGoBack()) {
            b.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
