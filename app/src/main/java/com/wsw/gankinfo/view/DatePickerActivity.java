package com.wsw.gankinfo.view;

import android.app.Activity;
import android.view.View;

import com.wsw.gankinfo.R;
import com.wsw.gankinfo.databinding.ActivityDatePickerBinding;
import com.wsw.gankinfo.di.component.AppComponent;
import com.wsw.gankinfo.di.component.DaggerDatePickerComponent;

import javax.inject.Inject;

import vm.EventViewModel;

/**
 * Created by wsw on 2016/12/20.
 */

public class DatePickerActivity extends BaseActivity<ActivityDatePickerBinding> {

    @Inject
    EventViewModel viewEvents;

    boolean isDismissing = false;


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerDatePickerComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_date_picker;
    }

    @Override
    protected void beforeSetViews() {
        b.setEvent(viewEvents);
    }

    @Override
    protected void setViews() {
        viewEvents.onClick.set(view -> {
            if (view == b.datePickFrame) {
                dismiss(view);
            } else if (view == b.choice) {
                setResult(DailyActivity.CHOICE_DATE);
                finishAfterTransition();
            }
        });
    }

    @Override
    protected void doTransaction() {

    }

    public void dismiss(View view) {
        isDismissing = true;
        setResult(Activity.RESULT_CANCELED);
        finishAfterTransition();
    }

    @Override
    public void onBackPressed() {
        dismiss(null);
    }
}
