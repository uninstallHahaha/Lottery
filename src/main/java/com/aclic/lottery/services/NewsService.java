package com.aclic.lottery.services;

import com.aclic.lottery.Models.News;
import com.aclic.lottery.Models.User;

import java.util.List;

public interface NewsService {
    public List<News> getUsers();
    public List<News> findTopNews();
    public List<News> findAllScrs();
    public News findOne(String id);
    public int addUser(News news);
    public int delUser(String id);
    public int modUser(News news);

    //懒加载10条
    public List<News> lazyGetNews(int start);
}
