package com.wsw.gankinfo.net;

import com.wsw.gankinfo.bean.CookieResult;
import com.wsw.gankinfo.greendao.gen.CookieResultDao;

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

    private CookieResultDao cookieResultDao;

    @Inject
    public CookieInterceptor(CookieResultDao cookieResultDao) {
        this.cookieResultDao = cookieResultDao;
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
        CookieResult result = cookieResultDao.queryBuilder().where(CookieResultDao.Properties.Url.eq(url)).build().unique();
        //获取当前时间
        long time = System.currentTimeMillis();

        if (result == null) {   //如果为空,则向数据库中插入数据
            result = new CookieResult(url, bodyString, time);
            cookieResultDao.insert(result);
        } else {    //不为空则更新数据,设置时间
            result.setResult(bodyString);
            result.setTime(time);
            cookieResultDao.update(result);
        }

        return response;
    }
}
