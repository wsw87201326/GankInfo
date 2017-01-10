package com.wsw.gankinfo.utils;

import com.wsw.gankinfo.net.GankApi;

/**
 * Created by wsw on 2017/1/9.
 */

public class NetUtils {

    public static String getDayUrl(int year,int month,int day){
        return GankApi.BASE_URL+"day/"+year+"/"+month+"/"+day;
    }
}
