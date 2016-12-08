package com.wsw.gankinfo.presenter;

import android.content.Context;
import android.util.Log;

import com.wsw.gankinfo.bean.DailyResult;
import com.wsw.gankinfo.net.GankApi;

import java.util.Calendar;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Create By :wsw 2016-08-31 16:58
 */

public class DailyPresenter {
    private static final String TAG = "DailyPresenter";
    private GankApi gankApi;
    private Context context;

    @Inject
    Calendar calendar;

//    private UserViewModel userViewModel;

    @Inject
    public DailyPresenter(Context context, GankApi gankApi) {
        this.context = context;
        this.gankApi = gankApi;
    }

    public void attemptGetTodayData() {
        int year = calendar.get(Calendar.YEAR);
        int mouth = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);

        gankApi.getByDay(year,mouth,date)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<DailyResult>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onNext(DailyResult dailyResult) {
                        System.out.println(dailyResult);
                    }
                });
    }
//
//    private void checkVersion() {
//        hyApiClient.checkVersion()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Subscriber<AppInfo>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d(TAG, "getLocalVersion onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(AppInfo appInfo) {
//                        try {
//                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
//                            int serverVersion = Integer.parseInt(appInfo.getServerVersion().replace(".apk", "").replace("OM_", ""));
//                            if (serverVersion < packageInfo.versionCode) {
//                                downNewVersion();
//                            }else{
//                                login();
//                            }
//                        } catch (PackageManager.NameNotFoundException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//    }
//
//    private void login() {
//        hyApiClient.login(userViewModel.getAccount().toString(), userViewModel.getPassword().toString())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Subscriber<User>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d(TAG, "login onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onNext(User user) {
//                        getOwnPrivilege(user);
//                    }
//                });
//    }
//
//    private void downNewVersion() {
//
//    }
//
//    private void getOwnPrivilege(User user){
//        hyApiClient.getOwnPrivilege(user.getUserId(),user.getRoleSn())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Subscriber<List<Privilege>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d(TAG, "getOwnPrivilege onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<Privilege> privileges) {
//                        for (Privilege privilege : privileges) {
//                            Log.d(TAG, privilege.toString());
//                        }
//                    }
//                });
//    }
}
