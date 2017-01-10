package com.wsw.gankinfo.di.module;


import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.wsw.gankinfo.di.AppScope;
import com.wsw.gankinfo.model.vo.DailyVO;
import com.wsw.gankinfo.view.adapter.DailyAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * 用于提供主页所需部件 Created by wsw on 2016/12/8.
 */
@Module
public class DailyModule {

    private ObservableArrayList<DailyVO> mList;

    public DailyModule() {
        mList = new ObservableArrayList<>();
    }

    @Provides
    @AppScope
    ObservableArrayList<DailyVO> provideObservableArrayDailyVOList() {
        return mList;
    }

    @Provides
    @AppScope
    DailyAdapter provideDailyAdapter(ObservableArrayList<DailyVO> dailyVOs) {
        DailyAdapter dailyAdapter = new DailyAdapter(dailyVOs);
        dailyVOs.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<DailyVO>>() {
            @Override
            public void onChanged(ObservableList<DailyVO> dailyVOs) {
                dailyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<DailyVO> dailyVOs, int positionStart, int itemCount) {
                dailyAdapter.notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList<DailyVO> dailyVOs, int positionStart, int itemCount) {
                dailyAdapter.notifyItemRangeInserted(positionStart, itemCount);
                dailyAdapter.notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList<DailyVO> dailyVOs, int fromPosition, int toPosition, int itemCount) {
                dailyAdapter.notifyItemMoved(fromPosition, toPosition);
                dailyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onItemRangeRemoved(ObservableList<DailyVO> dailyVOs, int positionStart, int itemCount) {
                dailyAdapter.notifyItemRangeRemoved(positionStart, itemCount);
                dailyAdapter.notifyItemRangeChanged(positionStart, itemCount);
            }
        });
        return dailyAdapter;
    }

}
