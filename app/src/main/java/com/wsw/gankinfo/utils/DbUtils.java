package com.wsw.gankinfo.utils;

import com.wsw.gankinfo.bean.CookieResult;
import com.wsw.gankinfo.greendao.gen.CookieResultDao;

import org.greenrobot.greendao.rx.RxQuery;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * 数据库操作 Created by wsw on 2017/1/4.
 */
@SuppressWarnings("unused")
public class DbUtils {
    private final CookieResultDao cookieResultDao;

    @Inject
    public DbUtils(CookieResultDao cookieResultDao) {
        this.cookieResultDao = cookieResultDao;
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     *
     * @param cookieResult 实体
     **/
    public void saveData(CookieResult cookieResult) {
        cookieResultDao.save(cookieResult);
    }

    /**
     * 添加数据至数据库
     *
     * @param cookieResult 实体
     */
   public long insertData(CookieResult cookieResult) {
        return cookieResultDao.insert(cookieResult);
    }

    /**
     * 根据url查询CookieResult
     *
     * @param url 网址
     */
    public Observable<CookieResult> queryByUrlRx(String url) {
        return cookieResultDao.queryBuilder().where(CookieResultDao.Properties.Url.eq(url)).rx().unique();
    }

    /**
     * 根据url查询CookieResult
     *
     * @param url 网址
     */
    public CookieResult queryByUrl(String url) {
        return cookieResultDao.queryBuilder().where(CookieResultDao.Properties.Url.eq(url)).unique();
    }


    /**
     * 删除数据
     *
     * @param cookieResult 实体
     **/
    public void deleteData(CookieResult cookieResult) {
        cookieResultDao.delete(cookieResult);
    }


    /**
     * 更新数据
     *
     * @param cookieResult 实体
     **/
    public void updateData(CookieResult cookieResult) {
        cookieResultDao.update(cookieResult);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     *
     * @param cookieResult 实体
     **/
    public Observable<CookieResult> saveDataRx(CookieResult cookieResult) {
        return cookieResultDao.rx().save(cookieResult);
    }

    /**
     * 查询所有数据
     **/
    public Observable<List<CookieResult>> queryAllRx() {
        RxQuery<CookieResult> rxQuery = cookieResultDao.queryBuilder().rx();
        return rxQuery.list();
    }

    /**
     * 删除数据
     *
     * @param cookieResult 实体
     **/
    public Observable<Void> deleteDataRx(CookieResult cookieResult) {
        return cookieResultDao.rx().delete(cookieResult);
    }

    /**
     * 删除全部数据
     **/
    public Observable<Void> deleteAllRx() {
        return cookieResultDao.rx().deleteAll();
    }

    /**
     * 更新数据
     *
     * @param cookieResult 实体
     **/
    public Observable<CookieResult> updateDataRx(CookieResult cookieResult) {
        return cookieResultDao.rx().update(cookieResult);
    }

    /**
     * 添加数据至数据库
     *
     * @param cookieResult 实体
     */
    Observable<CookieResult> insertDataRx(CookieResult cookieResult) {
        return cookieResultDao.rx().insert(cookieResult);
    }

    /**
     * 添加数据至数据库
     *
     * @param cookieResults 实体
     */
    Observable<Iterable<CookieResult>> insertDataRx(List<CookieResult> cookieResults) {
        if (null == cookieResults || cookieResults.size() <= 0) {
            return Observable.error(new Throwable("null"));
        }
        return cookieResultDao.rx().insertInTx(cookieResults);
    }


}
