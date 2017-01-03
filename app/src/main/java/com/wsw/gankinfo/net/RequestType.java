package com.wsw.gankinfo.net;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 请求类型 Created by wsw on 2016/12/6.
 */
@SuppressWarnings("unused")
public class RequestType {
    public static final int 福利 = 0x01;
    public static final int Android = 0x02;
    public static final int iOS = 0x03;
    public static final int 休息视频 = 0x04;
    public static final int 拓展资源 = 0x05;
    public static final int 前端 = 0x06;
    public static final int all = 0x07;

    @IntDef({福利, Android, iOS, 休息视频, 拓展资源, 前端, all})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestTypes {
    }

    private int userType;

    @RequestTypes
    public int getUserType() {
        return userType;
    }

    public void setUserType(@RequestTypes int userType) {
        this.userType = userType;
    }
}