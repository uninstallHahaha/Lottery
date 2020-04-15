package com.aclic.lottery.services.Impl;

import com.aclic.lottery.Models.News;
import com.aclic.lottery.daos.NewsDao;
import com.aclic.lottery.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> getUsers() {
        List<News> userList = newsDao.findAll();
        return userList;
    }

    @Override
    public List<News> findTopNews() {
        return newsDao.findTopNews();
    }

    @Override
    public List<News> findAllScrs() {
        return newsDao.findAllScrs();
    }

    @Override
    public News findOne(String id) {
        return newsDao.findOne(id);
    }

    @Override
    public int addUser(News u) {
        return newsDao.addUser(u);
    }

    @Override
    public int delUser(String id) {
        return newsDao.delUser(id);
    }

    @Override
    public int modUser(News u) {
        return newsDao.updateUser(u);
    }

    @Override
    public List<News> lazyGetNews(int start) {
        return newsDao.lazyGetNews(start);
    }
}
