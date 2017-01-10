package com.wsw.gankinfo.net;

import android.util.Log;

import com.wsw.gankinfo.bean.CookieResult;
import com.wsw.gankinfo.utils.DbUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * 缓存拦截器,主要用于存入数据库 Created by wsw on 2016/12/28.
 */
public class CookieInterceptor implements Interceptor {
    private static final String TAG = "CookieInterceptor";
    private DbUtils dbUtils;

    @Inject
    public CookieInterceptor(DbUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取请求
        Request request = chain.request();
        //获取结果
        Response response = chain.proceed(request);
        ResponseBody body = response.body();
        BufferedSource source = body.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        Charset charset = Charset.defaultCharset();
        MediaType contentType = body.contentType();
        if (contentType != null) {
            charset = contentType.charset(charset);
        }
        //获取数据
        String bodyString = buffer.clone().readString(charset);
        //获取url
        String url = request.url().toString();
        //greenDao中查找数据
        CookieResult cookieResult = dbUtils.queryByUrl(url);
            long time = System.currentTimeMillis();
            if (null != cookieResult) {
                cookieResult.setResult(bodyString);
                cookieResult.setTime(time);
                dbUtils.updateData(cookieResult);
            } else {
                Log.i(TAG,"save to db....");
                dbUtils.insertData(new CookieResult(null,url, bodyString, time));
            }

        return response;
    }
}
