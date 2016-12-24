package com.wsw.gankinfo.presenter;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.util.Log;

import com.wsw.gankinfo.model.dto.DailyCategoryDTO;
import com.wsw.gankinfo.model.dto.DailyDTO;
import com.wsw.gankinfo.model.vo.DailyVO;
import com.wsw.gankinfo.net.GankApi;
import com.wsw.gankinfo.utils.DailyUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import vm.DailyImgViewModel;

/**
 * Create By :wsw 2016-08-31 16:58
 */

public class DailyPresenter {
    private static final String TAG = "DailyPresenter";
    private GankApi gankApi;
    private Context context;
    private ObservableArrayList<DailyVO> mList; // 界面的数据对象
    private Calendar calendar;
    private DailyImgViewModel dailyImgViewModel;

    @Inject
    public DailyPresenter(Context context, GankApi gankApi, ObservableArrayList<DailyVO> mList) {
        this.context = context;
        this.gankApi = gankApi;
        this.mList = mList;
    }

    public void setDailyImgViewModel(DailyImgViewModel dailyImgViewModel) {
        this.dailyImgViewModel = dailyImgViewModel;
    }

    public void attemptGetDataByTime(int year, int mouth, int date) {
//        Observable.just(TestUrils.getByTest())
        gankApi.getByDay(year, mouth, date)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(DailyDTO::getResults)
                .observeOn(Schedulers.io())
                .flatMap(new Func1<DailyDTO.ResultsBean, Observable<List<DailyCategoryDTO>>>() {
                    @Override
                    public Observable<List<DailyCategoryDTO>> call(DailyDTO.ResultsBean resultsBean) {
                        return Observable.just(resultsBean.getAndroid(), resultsBean.getBoon(),
                                resultsBean.getFrontEnd(), resultsBean.getiOS(),
                                resultsBean.getRandom(), resultsBean.getRestVideo());
                    }
                })
                .flatMap(new Func1<List<DailyCategoryDTO>, Observable<DailyVO>>() {
                    @Override
                    public Observable<DailyVO> call(List<DailyCategoryDTO> dailyCategoryDTOs) {
                        List<DailyVO> list = new ArrayList<>();
                        if (null != dailyCategoryDTOs) {
                            for (DailyCategoryDTO dailyCategoryDTO : dailyCategoryDTOs) {
                                list.add(dailyCategoryDTO.transform());
                            }
                        }
                        DailyUtils.setFirstShowHead(list);
                        return Observable.from(list);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .filter(dailyVO -> {
                    if (dailyVO.getType().equals("福利")) {
                        dailyImgViewModel.url.set(dailyVO.getUrl());
                        dailyImgViewModel.time.set(dailyVO.getTime());
                        return false;
                    }
                    return true;
                })
                .subscribe(new Subscriber<DailyVO>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.e(TAG, "onError");
                    }

                    @Override
                    public void onNext(DailyVO dailyVO) {
                        Log.e("DailyPresenter", "subscribe:" + Thread.currentThread().getName());
                        mList.add(dailyVO);
                    }
                });
    }

}
