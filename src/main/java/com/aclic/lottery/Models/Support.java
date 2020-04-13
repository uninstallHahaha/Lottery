package com.aclic.lottery.Models;

public class Support {
    private String id;
    private String userid;
    private String newsid;
    private String createtime;

    public Support() {
    }

    public Support(String id, String userid, String newsid) {
        this.id = id;
        this.userid = userid;
        this.newsid = newsid;
    }

    public Support(String id, String userid, String newsid, String createtime) {
        this.id = id;
        this.userid = userid;
        this.newsid = newsid;
        this.createtime = createtime;
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
}
