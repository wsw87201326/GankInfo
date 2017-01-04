package com.wsw.gankinfo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wsw on 2017/1/3.
 */
@Entity
public class CookieResult {
    @Id(autoincrement = true)
    private Long id;
    /*url*/
    private String url;
    /*返回结果*/
    private String result;
    /*时间*/
    private long time;


    @Generated(hash = 430401114)
    public CookieResult(Long id, String url, String result, long time) {
        this.id = id;
        this.url = url;
        this.result = result;
        this.time = time;
    }


    @Generated(hash = 43459054)
    public CookieResult() {
    }


    @Override
    public String toString() {
        return "CookieResult{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", result='" + result + '\'' +
                ", time=" + time +
                '}';
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getUrl() {
        return this.url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getResult() {
        return this.result;
    }


    public void setResult(String result) {
        this.result = result;
    }


    public long getTime() {
        return this.time;
    }


    public void setTime(long time) {
        this.time = time;
    }
}
