package com.wsw.gankinfo.di.module;

import android.content.Context;

import com.wsw.gankinfo.greendao.gen.CookieResultDao;
import com.wsw.gankinfo.greendao.gen.DaoMaster;
import com.wsw.gankinfo.greendao.gen.DaoSession;
import com.wsw.gankinfo.utils.DbUtils;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 提供数据库管理的类 Created by wsw on 2017/1/3.
 */
@Module
public class CacheServiceModule {
    private final Context mContext;
    private final CookieResultDao cookieResultDao;

    public CacheServiceModule(Context context) {
        this.mContext = context;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mContext, "gank-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        this.cookieResultDao = daoSession.getCookieResultDao();
    }

    @Provides
    @Singleton
    DbUtils provideDbUtils() {
        return new DbUtils(cookieResultDao);
    }

}
