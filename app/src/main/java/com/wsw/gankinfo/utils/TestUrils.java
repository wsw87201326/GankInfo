package com.wsw.gankinfo.utils;

import com.google.gson.Gson;

import com.wsw.gankinfo.model.dto.DailyDTO;

/**
 * Created by wsw on 2016/12/19.
 */

public class TestUrils {
    public static DailyDTO getByTest() {
        Gson gson = new Gson();
        return gson.fromJson(result, DailyDTO.class);
    }

    private static final String result = "{\"category\":[\"iOS\",\"Android\",\"休息视频\",\"福利\",\"瞎推荐\"],\"error\":false,\"results\":{\"Android\":[{\"_id\":\"58560c74421aa97237bca8c3\",\"createdAt\":\"2016-12-18T12:11:32.877Z\",\"desc\":\"Facebook 开源文本布局库。\",\"images\":[\"http://img.gank.io/e3b5daff-b726-43f0-a42e-18be5b21c11e\"],\"publishedAt\":\"2016-12-19T11:57:16.232Z\",\"source\":\"chrome\",\"type\":\"Android\",\"url\":\"https://github.com/facebookincubator/TextLayoutBuilder\",\"used\":true,\"who\":\"Jason\"},{\"_id\":\"585757ec421aa9723d29b974\",\"createdAt\":\"2016-12-19T11:45:48.555Z\",\"desc\":\"JakeWharton 开源的新的 Rx 操作符：WindowIfChanged，检测 Window 变化状态，发出通知。\",\"images\":[\"http://img.gank.io/cc9e9cf4-15aa-4dd3-9215-b5f80f557948\"],\"publishedAt\":\"2016-12-19T11:57:16.232Z\",\"source\":\"chrome\",\"type\":\"Android\",\"url\":\"https://github.com/JakeWharton/RxWindowIfChanged\",\"used\":true,\"who\":\"代码家\"}],\"iOS\":[{\"_id\":\"585582ab421aa9723d29b970\",\"createdAt\":\"2016-12-18T02:23:39.454Z\",\"desc\":\"干货：最详细的iOS难点之CoreData讲解，附实例源码\",\"images\":[\"http://img.gank.io/9d0aea5b-d645-49bc-8395-15d9f20c24ad\",\"http://img.gank.io/a639a461-96c3-44f9-9c70-b1c4dbeafe2c\"],\"publishedAt\":\"2016-12-19T11:57:16.232Z\",\"source\":\"chrome\",\"type\":\"iOS\",\"url\":\"http://www.imlifengfeng.com/blog/?p=325\",\"used\":true,\"who\":\"feng\"},{\"_id\":\"5856c0f6421aa97237bca8c6\",\"createdAt\":\"2016-12-19T01:01:42.752Z\",\"desc\":\"高度可定制化日历视图，轻松实现范围选中效果\",\"images\":[\"http://img.gank.io/5195f823-cbbb-4b03-ab9b-f405ebbf9a1b\"],\"publishedAt\":\"2016-12-19T11:57:16.232Z\",\"source\":\"web\",\"type\":\"iOS\",\"url\":\"https://github.com/LZTuna/ZYCalendar\",\"used\":true,\"who\":null},{\"_id\":\"58575867421aa9723d29b976\",\"createdAt\":\"2016-12-19T11:47:51.254Z\",\"desc\":\"一个指令，把一个网址，变成一个 Mac App\",\"images\":[\"http://img.gank.io/831c9a52-e2ed-41a2-b1b2-1de060eca385\"],\"publishedAt\":\"2016-12-19T11:57:16.232Z\",\"source\":\"chrome\",\"type\":\"iOS\",\"url\":\"https://github.com/jiahaog/nativefier\",\"used\":true,\"who\":\"代码家\"}],\"休息视频\":[{\"_id\":\"58568e04421aa9723d29b972\",\"createdAt\":\"2016-12-18T21:24:20.288Z\",\"desc\":\"波兰温馨圣诞广告\",\"publishedAt\":\"2016-12-19T11:57:16.232Z\",\"source\":\"chrome\",\"type\":\"休息视频\",\"url\":\"https://v.qq.com/x/page/s0353eggn8b.html\",\"used\":true,\"who\":\"lxxself\"}],\"瞎推荐\":[{\"_id\":\"58574fb3421aa97237bca8c8\",\"createdAt\":\"2016-12-19T11:10:43.425Z\",\"desc\":\"基础深度学习概念备忘录\",\"publishedAt\":\"2016-12-19T11:57:16.232Z\",\"source\":\"web\",\"type\":\"瞎推荐\",\"url\":\"https://zhuanlan.zhihu.com/p/24436419\",\"used\":true,\"who\":\"王下邀月熊(Chevalier)\"}],\"福利\":[{\"_id\":\"58569ab6421aa97237bca8c5\",\"createdAt\":\"2016-12-18T22:18:30.807Z\",\"desc\":\"12-18\",\"publishedAt\":\"2016-12-19T11:57:16.232Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww4.sinaimg.cn/large/610dc034jw1favb116hm2j20u00u0gqi.jpg\",\"used\":true,\"who\":\"daimajia\"}]}}";
}
