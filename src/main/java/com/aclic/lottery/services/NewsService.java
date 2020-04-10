package com.aclic.lottery.services;

import com.aclic.lottery.Models.News;
import com.aclic.lottery.Models.User;

import java.util.List;

public interface NewsService {
    public List<News> getUsers();
    public int addUser(News news);
    public int delUser(String id);
    public int modUser(News news);
}
