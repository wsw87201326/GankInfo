package com.wsw.gankinfo.presenter;

import com.google.gson.Gson;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.util.Log;
import android.widget.Toast;

import com.wsw.gankinfo.bean.CookieResult;
import com.wsw.gankinfo.model.dto.DailyCategoryDTO;
import com.wsw.gankinfo.model.dto.DailyDTO;
import com.wsw.gankinfo.model.vo.DailyVO;
import com.wsw.gankinfo.net.GankApi;
import com.wsw.gankinfo.utils.DailyUtils;
import com.wsw.gankinfo.utils.DbUtils;
import com.wsw.gankinfo.utils.NetUtils;

import java.util.ArrayList;
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
    private DailyImgViewModel dailyImgViewModel;
    private DbUtils dbUtils;
    private Gson gson;

    @Inject
    public DailyPresenter(Context context, GankApi gankApi,
                          ObservableArrayList<DailyVO> mList, DbUtils dbUtils, Gson gson) {
        this.context = context;
        this.gankApi = gankApi;
        this.mList = mList;
        this.dbUtils = dbUtils;
        this.gson = gson;
    }

    public void setDailyImgViewModel(DailyImgViewModel dailyImgViewModel) {
        this.dailyImgViewModel = dailyImgViewModel;
    }

    public void attemptGetDataByTime(int year, int mouth, int date) {
        Observable.concat(getByDb(year, mouth, date), getByNet(year, mouth, date))
                .first()
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
                .map(dailyCategoryDTOs -> {
                    List<DailyVO> list = new ArrayList<>();
                    if (null != dailyCategoryDTOs) {
                        for (DailyCategoryDTO dailyCategoryDTO : dailyCategoryDTOs) {
                            list.add(dailyCategoryDTO.transform());
                        }
                    }
                    DailyUtils.setFirstShowHead(list);
                    return list;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .filter(list -> {//如果是福利,则是作为顶部图片,需要过滤掉,不放在列表中
                    for (DailyVO dailyVO : list) {
                        if (dailyVO.getType().equals("福利")) {
                            dailyImgViewModel.url.set(dailyVO.getUrl());
                            dailyImgViewModel.time.set(dailyVO.getTime());
                            return false;
                        }
                        return true;
                    }
                    return true;
                })
                .subscribe(new Subscriber<List<DailyVO>>() {

                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "完成了");
                        unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO: 2016/12/26 错误处理
                        e.printStackTrace();
                        Log.e(TAG, "出错了");
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(List<DailyVO> list) {
                        mList.addAll(list);
                    }
                });
    }

    /**
     * 从网络获取数据
     *
     * @param year  年
     * @param mouth 月
     * @param date  日
     */
    private Observable<DailyDTO> getByNet(int year, int mouth, int date) {
        return gankApi.getByDay(year, mouth, date).doOnNext(dailyDTO -> Log.i(TAG, "从网络获取!!!"));
    }

    /**
     * 从数据库获取数据
     *
     * @param year  年
     * @param mouth 月
     * @param date  日
     */
    private Observable<DailyDTO> getByDb(int year, int mouth, int date) {
        return dbUtils.queryByUrlRx(NetUtils.getDayUrl(year, mouth, date))
                .filter(cookieResult -> cookieResult != null)
                .map(CookieResult::getResult)
                .map(s -> gson.fromJson(s, DailyDTO.class))
                .doOnNext(dailyDTO -> Log.i(TAG, "从数据库读取!!!"));
    }

}
