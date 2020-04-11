package com.aclic.lottery.Models;

import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.Date;

public class News {

    private String id;
    private String title;
    private String content;
    private Integer zan;
    private Date createtime;

    public News(){}

    public News(String title, String content, Integer zan, Date createtime) {
        this.title = title;
        this.content = content;
        this.zan = zan;
        this.createtime = createtime;
    }

    public News(String title, String content, Integer zan) {
        this.title = title;
        this.content = content;
        this.zan = zan;
    }

    public News(String id, String title, String content, Integer zan) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.zan = zan;
    }

    public News(String id, String title, String content, Integer zan, Date createtime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.zan = zan;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "news{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", zan=" + zan +
                '}';
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