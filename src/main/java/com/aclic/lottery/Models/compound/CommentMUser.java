package com.aclic.lottery.Models.compound;

import java.util.Date;

public class CommentMUser {

    private String id;
    private String newsid;
    private String userid;
    private String content;
    private Date createtime;
    private String account;
    private String av;

    public CommentMUser(){}

    public CommentMUser(String id, String newsid, String userid, String content, Date createtime, String account) {
        this.id = id;
        this.newsid = newsid;
        this.userid = userid;
        this.content = content;
        this.createtime = createtime;
        this.account = account;
    }

    public CommentMUser(String id, String newsid, String userid, String content, Date createtime, String account, String av) {
        this.id = id;
        this.newsid = newsid;
        this.userid = userid;
        this.content = content;
        this.createtime = createtime;
        this.account = account;
        this.av = av;
    }

    public String getAv() {
        return av;
    }

    public void setAv(String av) {
        this.av = av;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
