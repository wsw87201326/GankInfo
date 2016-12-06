package com.wsw.gankinfo.bean;

import java.util.List;

/**
 * 返回结果实体类 Created by wsw on 2016/12/5.
 */
@SuppressWarnings("unused")
public class Result {

    /**
     * error : false results : [{"_id":"583d03fb421aa939b58d31a7","createdAt":"2016-11-29T12:28:43.726Z","desc":"在
     * Instagram 团队重写他们全新的 iOS Feed 的过程中，他们积累了大量的经验，遇到的坑无疑已经超出了他们的预料，比如说集合视图、差异化 (Diffing)
     * 以及冗长代码所带来的危险之处。在本次 try! Swift 讲演之中，Ryan Nystrom 向我们分享了如何才能进行一次成功的重构，并且向我们介绍了 Instagram
     * 的一个很赞的开源组件：IGListKit。","images":["http://img.gank.io/5bc973a7-2447-4d90-8cc0-0ae2262d57db"],"publishedAt":"2016-12-05T11:40:51.351Z","source":"chrome","type":"iOS","url":"https://realm.io/cn/news/tryswift-ryan-nystrom-refactoring-at-scale-lessons-learned-rewriting-instagram-feed/","used":true,"who":"beeender"},{"_id":"58412a25421aa939b58d31cb","createdAt":"2016-12-02T16:00:37.233Z","desc":"像Android
     * R文件一样管理资源","publishedAt":"2016-12-05T11:40:51.351Z","source":"chrome","type":"iOS","url":"https://github.com/mac-cain13/R.swift","used":true,"who":"Dear宅学长"},{"_id":"584186c7421aa939b58d31cd","createdAt":"2016-12-02T22:35:51.517Z","desc":"美团：常见性能优化策略的总结","publishedAt":"2016-12-05T11:40:51.351Z","source":"web","type":"Android","url":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651745738&idx=1&sn=413a287d6919daed31a5b3192edab3af&chksm=bd12b4878a653d91916ee74556c1eab20423ce1ee060fe4eab8ce1c46c80cc2d59afe85bd601&scene=0#rd","used":true,"who":null},{"_id":"584415e4421aa939bb4637f0","createdAt":"2016-12-04T21:11:00.62Z","desc":"干货IO
     * 3.0，GankIO的第三方客户端，含有搜索，最新的闲读，及收藏功能。 ","images":["http://img.gank.io/918d1f3d-a553-4856-974c-5bd5abfd5b97"],"publishedAt":"2016-12-05T11:40:51.351Z","source":"web","type":"Android","url":"https://github.com/burgessjp/GanHuoIO/blob/master/README.md","used":true,"who":"solid"},{"_id":"58443ccf421aa939b58d31d7","createdAt":"2016-12-04T23:57:03.456Z","desc":"简单几步助你优化React应用包体","publishedAt":"2016-12-05T11:40:51.351Z","source":"web","type":"前端","url":"https://segmentfault.com/a/1190000007692543","used":true,"who":"王下邀月熊(Chevalier)"},{"_id":"5844b8dd421aa939befafb03","createdAt":"2016-12-05T08:46:21.259Z","desc":"12-5","publishedAt":"2016-12-05T11:40:51.351Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034gw1fafmi73pomj20u00u0abr.jpg","used":true,"who":"daimajia"},{"_id":"5844d3b0421aa939b58d31d9","createdAt":"2016-12-05T10:40:48.204Z","desc":"Android
     * 智能 Scheduler，根据用户手机场景，决定任务执行方式。","publishedAt":"2016-12-05T11:40:51.351Z","source":"chrome","type":"Android","url":"https://github.com/hypertrack/smart-scheduler-android","used":true,"who":"代码家"},{"_id":"5844debf421aa939b58d31da","createdAt":"2016-12-05T11:27:59.611Z","desc":"最近超火的一则公益广告，主题相当棒。","publishedAt":"2016-12-05T11:40:51.351Z","source":"chrome","type":"休息视频","url":"https://v.qq.com/x/page/w0352quxhpx.html","used":true,"who":"代码家"},{"_id":"58259f06421aa91369f95a31","createdAt":"2016-11-11T18:35:50.62Z","desc":"史上最强，易用可扩展的
     * Android log 库","publishedAt":"2016-12-02T12:13:34.224Z","source":"web","type":"Android","url":"https://github.com/elvishew/XLog","used":true,"who":"Elvis
     * Hew"},{"_id":"582959d9421aa911e32d87db","createdAt":"2016-11-14T14:29:45.1Z","desc":"iOS
     * 平台高效转换引擎 json->model,model->json,model->Dictionary, 支持模型类继承其他模型类, 支持指定路径转换, 不区分 json 的 key
     * 和模型属性名称大小写, 自动处理 json 中 null","publishedAt":"2016-12-02T12:13:34.224Z","source":"web","type":"iOS","url":"https://github.com/netyouli/WHC_Model","used":true,"who":"吴海超(WHC)"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    private static class ResultsBean {
        /**
         * _id : 583d03fb421aa939b58d31a7 createdAt : 2016-11-29T12:28:43.726Z desc : 在 Instagram
         * 团队重写他们全新的 iOS Feed 的过程中，他们积累了大量的经验，遇到的坑无疑已经超出了他们的预料，比如说集合视图、差异化 (Diffing)
         * 以及冗长代码所带来的危险之处。在本次 try! Swift 讲演之中，Ryan Nystrom 向我们分享了如何才能进行一次成功的重构，并且向我们介绍了 Instagram
         * 的一个很赞的开源组件：IGListKit。 images : ["http://img.gank.io/5bc973a7-2447-4d90-8cc0-0ae2262d57db"]
         * publishedAt : 2016-12-05T11:40:51.351Z source : chrome type : iOS url :
         * https://realm.io/cn/news/tryswift-ryan-nystrom-refactoring-at-scale-lessons-learned-rewriting-instagram-feed/
         * used : true who : beeender
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    ", images=" + images +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
