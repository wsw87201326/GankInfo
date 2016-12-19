package com.wsw.gankinfo.net;


import com.wsw.gankinfo.bean.Result;
import com.wsw.gankinfo.model.dto.DailyDTO;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 网络访问接口 Created by wsw on 2016/12/5.
 */
@SuppressWarnings("unused")
public interface GankApi {

    /**
     * 根据类别获取数据 http://gank.io/api/data/数据类型/请求个数/第几页
     *
     * @param type       数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param count      请求个数： 数字，大于0
     * @param pagination 第几页：数字，大于0
     * @return 数据
     */
    @GET("data/{type}/{count}/{pagination}")
    Observable<Result> getByType(@Path("type") String type, @Path("count") int count, @Path("pagination") int pagination);


    /**
     * 根据日期获取数据 http://gank.io/api/day/年/月/日
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return 数据
     */
    @GET("day/{year}/{month}/{day}")
    Observable<DailyDTO> getByDay(@Path("year") int year, @Path("month") int month, @Path("day") int day);


    /**
     * 随机获取数据 http://gank.io/api/random/data/分类/个数
     *
     * @param type  数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * @param count 个数： 数字，大于0
     */
    @GET("random/data/{type}/{count}")
    Observable<Result> getRandom(@Path("type") String type, @Path("count") int count);

    /**
     * 搜索 http://gank.io/api/search/query/listview/category/Android/count/10/page/1
     *
     * @param type       数据类型：all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     * @param count      返回个数 数字，大于0
     * @param pagination 第几页：数字，大于0
     * @return 数据
     */
    @GET("search/query/listview/category/{type}/count/{count}/page/{pagination}")
    Observable<Result> search(@Path("type") String type, @Path("count") int count, @Path("pagination") int pagination);

}
