package com.wsw.gankinfo.bean;

import java.util.List;

/**
 * Created by wsw on 2016/12/8.
 */

@SuppressWarnings("unused")
public class DailyResult {

    /**
     * category : ["休息视频","Android","iOS","前端","瞎推荐","福利"]
     * error : false
     * results : {"Android":[{"_id":"58480f81421aa963efd90da0","createdAt":"2016-12-07T21:32:49.97Z","desc":"子线程到底能不能更新View?非常详细的解答","publishedAt":"2016-12-08T11:42:08.186Z","source":"web","type":"Android","url":"http://www.cnblogs.com/lao-liang/p/5108745.html","used":true,"who":"Li Wenjing"},{"_id":"58481988421aa963ed5064ea","createdAt":"2016-12-07T22:15:36.986Z","desc":"一款简洁，实用，美观的天气应用，通过源码还能学到更多","images":["http://img.gank.io/d87d24a4-24a3-46c0-aaf7-ae3d657485cf"],"publishedAt":"2016-12-08T11:42:08.186Z","source":"web","type":"Android","url":"https://github.com/SilenceDut/KnowWeather","used":true,"who":null},{"_id":"58484775421aa963f321b02e","createdAt":"2016-12-08T01:31:33.540Z","desc":"主题换色，夜间模式，省流量策略。。。这可能是最友好的Gank.io(干货集中营)客户端了","images":["http://img.gank.io/0995f5f4-9b1e-485a-ade2-fd734afad66b","http://img.gank.io/9f633f51-dee6-4658-a617-8ed9961a2384"],"publishedAt":"2016-12-08T11:42:08.186Z","source":"web","type":"Android","url":"https://github.com/wangdicoder/react-native-Gank","used":true,"who":"Di Wang"}],"iOS":[{"_id":"584816ae421aa963efd90da1","createdAt":"2016-12-07T22:03:26.965Z","desc":"Swift 3关于函数类型的一项重要提议","images":["http://img.gank.io/d2e8101e-1694-42b9-a2c9-a5b5ea477435"],"publishedAt":"2016-12-08T11:42:08.186Z","source":"web","type":"iOS","url":"https://boxueio.com/series/functions-and-closure/episode/149","used":true,"who":null},{"_id":"5848c62d421aa963f321b034","createdAt":"2016-12-08T10:32:13.9Z","desc":"类似 Pinterest 的 Segement 组件效果","images":["http://img.gank.io/e1a01603-6bea-4a84-bfb5-260159cb438c"],"publishedAt":"2016-12-08T11:42:08.186Z","source":"chrome","type":"iOS","url":"https://github.com/TBXark/PinterestSegment","used":true,"who":"代码家"},{"_id":"5848c788421aa963eaaee143","createdAt":"2016-12-08T10:38:00.281Z","desc":"简洁的 iOS 悬浮消息栏","images":["http://img.gank.io/f872c8cf-720c-4f5e-8f76-1d2e4e53857b","http://img.gank.io/2f8aebb5-bd42-4de9-9d42-095f2be6c71a"],"publishedAt":"2016-12-08T11:42:08.186Z","source":"chrome","type":"iOS","url":"https://github.com/hyperoslo/Whisper","used":true,"who":"代码家"}],"休息视频":[{"_id":"58424ddf421aa939b58d31d0","createdAt":"2016-12-03T12:45:19.291Z","desc":"2016年，还有一个月就要过完了。一段视频告诉你，2016年都发生过什么事。","publishedAt":"2016-12-08T11:42:08.186Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/7-D3d0-dWtSaKcMWC9o4yw__.htm","used":true,"who":"lxxself"}],"前端":[{"_id":"58482b86421aa963eaaee13e","createdAt":"2016-12-07T23:32:22.869Z","desc":"《基于React的前端工程实战》大纲，也是笔者心中的前端学习路线图","publishedAt":"2016-12-08T11:42:08.186Z","source":"web","type":"前端","url":"https://segmentfault.com/a/1190000007730440","used":true,"who":"王下邀月熊(Chevalier)"}],"瞎推荐":[{"_id":"5848c87d421aa963ed5064ef","createdAt":"2016-12-08T10:42:05.417Z","desc":"基于图像的随机可视化，谜一样的美。","images":["http://img.gank.io/c3839d1d-1172-457c-93ec-4804592c1c45"],"publishedAt":"2016-12-08T11:42:08.186Z","source":"chrome","type":"瞎推荐","url":"https://github.com/victorBaro/AlgoGraphics","used":true,"who":"代码家"}],"福利":[{"_id":"5848c92e421aa963efd90da4","createdAt":"2016-12-08T10:45:02.271Z","desc":"12-8","publishedAt":"2016-12-08T11:42:08.186Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1faj6sozkluj20u00nt75p.jpg","used":true,"who":"代码家"}]}
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
        private List<CategoryBean> Android;
        private List<CategoryBean> iOS;
        private List<CategoryBean> 休息视频;
        private List<CategoryBean> 前端;
        private List<CategoryBean> 瞎推荐;
        private List<CategoryBean> 福利;

        public List<CategoryBean> getAndroid() {
            return Android;
        }

        public void setAndroid(List<CategoryBean> Android) {
            this.Android = Android;
        }

        public List<CategoryBean> getIOS() {
            return iOS;
        }

        public void setIOS(List<CategoryBean> iOS) {
            this.iOS = iOS;
        }

        public List<CategoryBean> get休息视频() {
            return 休息视频;
        }

        public void set休息视频(List<CategoryBean> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public List<CategoryBean> get前端() {
            return 前端;
        }

        public void set前端(List<CategoryBean> 前端) {
            this.前端 = 前端;
        }

        public List<CategoryBean> get瞎推荐() {
            return 瞎推荐;
        }

        public void set瞎推荐(List<CategoryBean> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public List<CategoryBean> get福利() {
            return 福利;
        }

        public void set福利(List<CategoryBean> 福利) {
            this.福利 = 福利;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "Android=" + Android +
                    ", iOS=" + iOS +
                    ", 休息视频=" + 休息视频 +
                    ", 前端=" + 前端 +
                    ", 瞎推荐=" + 瞎推荐 +
                    ", 福利=" + 福利 +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DailyResult{" +
                "error=" + error +
                ", results=" + results +
                ", category=" + category +
                '}';
    }
}
