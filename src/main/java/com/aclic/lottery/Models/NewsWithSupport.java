package com.aclic.lottery.Models;

import java.util.Date;

//封装了是否赞同的news
public class NewsWithSupport {

    private String id;
    private String title;
    private String content;
    private Integer zan;
    private Date createtime;
    private boolean ifSupport;

    public NewsWithSupport(){}

    public NewsWithSupport(String title, String content, Integer zan, Date createtime) {
        this.title = title;
        this.content = content;
        this.zan = zan;
        this.createtime = createtime;
    }

    public NewsWithSupport(String title, String content, Integer zan) {
        this.title = title;
        this.content = content;
        this.zan = zan;
    }

    public NewsWithSupport(String id, String title, String content, Integer zan) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.zan = zan;
    }

    public NewsWithSupport(String id, String title, String content, Integer zan, Date createtime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.zan = zan;
        this.createtime = createtime;
    }

    public NewsWithSupport(String id, String title, String content, Integer zan, Date createtime, boolean ifSupport) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.zan = zan;
        this.createtime = createtime;
        this.ifSupport = ifSupport;
    }

    public boolean isIfSupport() {
        return ifSupport;
    }

    public void setIfSupport(boolean ifSupport) {
        this.ifSupport = ifSupport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
