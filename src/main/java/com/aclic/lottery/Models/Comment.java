package com.aclic.lottery.Models;

import org.joda.time.DateTime;

public class Comment {

    private String id;
    private String newsid;
    private String userid;
    private String content;
    private DateTime createtime;

    public Comment(){}

    public Comment(String newsid, String userid, String content, DateTime createtime) {
        this.newsid = newsid;
        this.userid = userid;
        this.content = content;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", newsid='" + newsid + '\'' +
                ", userid='" + userid + '\'' +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(DateTime createtime) {
        this.createtime = createtime;
    }
}
