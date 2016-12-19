package com.wsw.gankinfo.utils;

import com.wsw.gankinfo.model.vo.DailyVO;

import java.util.List;

/**
 * Created by wsw on 2016/12/13.
 */

public class DailyUtils {

    public static List<DailyVO> setFirstShowHead(List<DailyVO> list) {
        if (null != list && list.size() > 0) {
            list.get(0).setHead(true);
        }
        return list;
    }
}
