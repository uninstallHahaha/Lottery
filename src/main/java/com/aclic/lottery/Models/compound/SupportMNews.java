package com.aclic.lottery.Models.compound;

public class SupportMNews {
    private String id;
    private String userid;
    private String newsid;
    private String createtime;

    private String title;

    public SupportMNews() {
    }

    public SupportMNews(String id, String userid, String newsid, String createtime, String title) {
        this.id = id;
        this.userid = userid;
        this.newsid = newsid;
        this.createtime = createtime;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
