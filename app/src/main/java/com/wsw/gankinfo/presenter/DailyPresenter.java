package com.wsw.gankinfo.presenter;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.util.Log;
import android.widget.Toast;

import com.wsw.gankinfo.model.dto.DailyCategoryDTO;
import com.wsw.gankinfo.model.dto.DailyDTO;
import com.wsw.gankinfo.model.vo.DailyVO;
import com.wsw.gankinfo.net.GankApi;
import com.wsw.gankinfo.utils.DailyUtils;
import com.wsw.gankinfo.utils.DbUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    private DbUtils dbUtils;

    public DailyPresenter(Context context, GankApi gankApi, ObservableArrayList<DailyVO> mList, DbUtils dbUtils) {
        this.context = context;
        this.gankApi = gankApi;
        this.mList = mList;
        this.dbUtils = dbUtils;
    }

    public void setDailyImgViewModel(DailyImgViewModel dailyImgViewModel) {
        this.dailyImgViewModel = dailyImgViewModel;
    }

    public void attemptGetDataByTime(int year, int mouth, int date) {
//        Observable.just(TestUrils.getByTest())
        gankApi.getByDay(year, mouth, date)
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
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(dailyVO -> {
                    if (mList.size() != 0) {
                        mList.clear();
                    }
                })
                .observeOn(Schedulers.io())
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
                        unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO: 2016/12/26 错误处理
                        e.printStackTrace();
                        Log.e(TAG, "onError");
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(DailyVO dailyVO) {
                        Log.e("DailyPresenter", "subscribe:" + Thread.currentThread().getName());
                        mList.add(dailyVO);
                    }
                });
    }

}
