package com.wsw.gankinfo.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 网络数据DTO Created by wsw on 2016/12/11.
 */
@SuppressWarnings("unused")
public class DailyDTO {

    /**
     * category : ["iOS","拓展资源","Android","福利","前端","休息视"] error : false results :
     * {"Android":[{"_id":"5847f803421aa963eaaee13b","createdAt":"2016-12-07T19:52:35.560Z","desc":"Gradle组件化优化","publishedAt":"2016-12-09T11:33:12.481Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/5343f38c0723","used":true,"who":null},{"_id":"5848d934421aa963eaaee145","createdAt":"2016-12-08T11:53:24.587Z","desc":"傻瓜式
     * Material Design 风格矢量图标生成器","publishedAt":"2016-12-09T11:33:12.481Z","source":"web","type":"Android","url":"http://jaqen.me/mdpub","used":true,"who":null},{"_id":"5849fda2421aa963efd90dac","createdAt":"2016-12-09T08:41:06.309Z","desc":"拍照时之拍预览界面指定区域的照片","images":["http://img.gank.io/42358c4d-24d2-4771-bce0-5d9ac7f49638"],"publishedAt":"2016-12-09T11:33:12.481Z","source":"web","type":"Android","url":"https://github.com/CGmaybe10/FocusSurfaceView","used":true,"who":null},{"_id":"584a0be4421aa963efd90dae","createdAt":"2016-12-09T09:41:56.4Z","desc":"一个全能的水波加载动画","images":["http://img.gank.io/c682af05-8572-4d58-92c9-dfb15fd70847"],"publishedAt":"2016-12-09T11:33:12.481Z","source":"web","type":"Android","url":"https://github.com/race604/WaveLoading","used":true,"who":"吴晶"},{"_id":"584a2164421aa963efd90daf","createdAt":"2016-12-09T11:13:40.718Z","desc":"完成度很高的一款
     * ePub Android 阅读器","images":["http://img.gank.io/807a2383-1388-47f1-97b9-d804681d5671","http://img.gank.io/b94efe6c-1a6e-4cc5-bd99-2283b1835110"],"publishedAt":"2016-12-09T11:33:12.481Z","source":"chrome","type":"Android","url":"https://github.com/FolioReader/FolioReader-Android","used":true,"who":"代码家"}],"iOS":[{"_id":"5847c9d5421aa963f321b026","createdAt":"2016-12-07T16:35:33.610Z","desc":"对绝大多数开发者来说，尽管我们每天都要与编译器打交道，然而实际上编译器对我们来说仍然像一个神秘的黑盒。在本次
     * try! Swift 的讲演中，Samuel Giddins 从头搭建了一个全新的微型编译器，用来编译他自制的一门编程语言，从而借此去学习编译器的基本工作机制。他还讲述了 Swift
     * 是如何为复杂问题（例如语义解析、词法分析和代码生成）提供优雅的解决方案的。最后，我们将实现一门全新的编程语言，并完成对它的编译工作！","images":["http://img.gank.io/8b94548f-0804-4683-bee7-8d7828f90abb","http://img.gank.io/8b3cf104-4b27-4dbd-8407-769d622ca077"],"publishedAt":"2016-12-09T11:33:12.481Z","source":"chrome","type":"iOS","url":"https://realm.io/cn/news/tryswift-samuel-giddins-building-tiny-compiler-swift-ios/","used":true,"who":"beeender"},{"_id":"584a1fc7421aa963ed5064f9","createdAt":"2016-12-09T11:06:47.769Z","desc":"iOS
     * 展示复杂数学公式的裤子","images":["http://img.gank.io/d814ddd5-a735-4ba2-b456-6fd6771411b1","http://img.gank.io/93ee438f-e87b-4375-9e8e-fe4ecaf5aac0","http://img.gank.io/eb74b42a-6695-4448-9696-086d288633b0"],"publishedAt":"2016-12-09T11:33:12.481Z","source":"chrome","type":"iOS","url":"https://github.com/kostub/iosMath","used":true,"who":"代码家"}],"休息视频":[{"_id":"584a24c9421aa963efd90db1","createdAt":"2016-12-09T11:28:09.186Z","desc":"周末福利时刻","publishedAt":"2016-12-09T11:33:12.481Z","source":"chrome","type":"休息视频","url":"https://v.qq.com/x/cover/ijijsovmnpyqbse/k00226iasqu.html","used":true,"who":"daimajia"}],"前端":[{"_id":"584a017d421aa963ed5064f7","createdAt":"2016-12-09T08:57:33.376Z","desc":"实时预览的线上
     * Makrdown 编辑器","images":["http://img.gank.io/46fa1d7d-472c-4cb0-99bf-bdf7a43b7255"],"publishedAt":"2016-12-09T11:33:12.481Z","source":"chrome","type":"前端","url":"https://github.com/laobubu/MarkdownIME","used":true,"who":"嗲马甲"},{"_id":"584a2059421aa963ed5064fa","createdAt":"2016-12-09T11:09:13.837Z","desc":"基于
     * Vuejs 实现的 UI lib","images":["http://img.gank.io/07394295-97a8-48c1-8159-6543c7772ccc"],"publishedAt":"2016-12-09T11:33:12.481Z","source":"chrome","type":"前端","url":"https://github.com/wangdahoo/vonic","used":true,"who":"daimajia
     * "}],"拓展资源":[{"_id":"5847f5fc421aa963f321b02a","createdAt":"2016-12-07T19:43:56.111Z","desc":"非常好用的Mac应用程序推荐","publishedAt":"2016-12-09T11:33:12.481Z","source":"web","type":"拓展资源","url":"https://jaywcjlove.github.io/awesome-mac/","used":true,"who":"小弟调调™"},{"_id":"584a0905421aa963f321b041","createdAt":"2016-12-09T09:29:41.938Z","desc":"剑指offer（java）合集","publishedAt":"2016-12-09T11:33:12.481Z","source":"web","type":"拓展资源","url":"http://blog.csdn.net/column/details/13357.html","used":true,"who":"FMT"}],"福利":[{"_id":"584a0130421aa963f321b040","createdAt":"2016-12-09T08:56:16.913Z","desc":"12-9","publishedAt":"2016-12-09T11:33:12.481Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1fak99uh554j20u00u0n09.jpg","used":true,"who":"代码家"}]}
     */

    private boolean error;
    private ResultsBean results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }


    public static class ResultsBean {
        @SerializedName("Android")
        private List<DailyCategoryDTO> android;
        @SerializedName("iOS")
        private List<DailyCategoryDTO> iOS;
        @SerializedName("休息视频")
        private List<DailyCategoryDTO> restVideo;
        @SerializedName("前端")
        private List<DailyCategoryDTO> frontEnd;
        @SerializedName("瞎推荐")
        private List<DailyCategoryDTO> random;
        @SerializedName("福利")
        private List<DailyCategoryDTO> boon;

        public List<DailyCategoryDTO> getAndroid() {
            return android;
        }

        public void setAndroid(List<DailyCategoryDTO> android) {
            this.android = android;
        }

        public List<DailyCategoryDTO> getiOS() {
            return iOS;
        }

        public void setiOS(List<DailyCategoryDTO> iOS) {
            this.iOS = iOS;
        }

        public List<DailyCategoryDTO> getRestVideo() {
            return restVideo;
        }

        public void setRestVideo(List<DailyCategoryDTO> restVideo) {
            this.restVideo = restVideo;
        }

        public List<DailyCategoryDTO> getFrontEnd() {
            return frontEnd;
        }

        public void setFrontEnd(List<DailyCategoryDTO> frontEnd) {
            this.frontEnd = frontEnd;
        }

        public List<DailyCategoryDTO> getRandom() {
            return random;
        }

        public void setRandom(List<DailyCategoryDTO> random) {
            this.random = random;
        }

        public List<DailyCategoryDTO> getBoon() {
            return boon;
        }

        public void setBoon(List<DailyCategoryDTO> boon) {
            this.boon = boon;
        }
    }
}
