package com.wsw.gankinfo.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.wsw.gankinfo.R;
import com.wsw.gankinfo.databinding.ActivityDatePickerBinding;
import com.wsw.gankinfo.di.component.AppComponent;
import com.wsw.gankinfo.di.component.DaggerDatePickerComponent;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import vm.EventViewModel;

/**
 * Created by wsw on 2016/12/20.
 */

public class DatePickerActivity extends BaseActivity<ActivityDatePickerBinding> {

    private static final String TAG = "DatePickerActivity";
    @Inject
    EventViewModel viewEvents;

    @Inject
    Calendar calendar;

    boolean isDismissing = false;
    Date maxTime;

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
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        maxTime = calendar.getTime();
    }

    @Override
    protected void setViews() {
        b.calendarView.state().edit()
                .setMaximumDate(maxTime)
                .commit();

        viewEvents.onClick.set(view -> {
            if (view == b.datePickFrame) {
                dismiss(view);
            } else if (view == b.choice) {
                CalendarDay calendarDay = b.calendarView.getSelectedDate();
                Intent intent = new Intent();
                intent.putExtra("year", calendarDay.getYear());
                intent.putExtra("mouth", calendarDay.getMonth() + 1);
                intent.putExtra("date", calendarDay.getDay());
                setResult(Activity.RESULT_OK, intent);
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
