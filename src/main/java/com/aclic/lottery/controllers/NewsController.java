package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.News;
import com.aclic.lottery.Models.User;
import com.aclic.lottery.services.NewsService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author Aclic
 */
@Controller
public class NewsController {

    //数据库timestamp , 默认CURRENT_TIMESTAMP
    //model 使用 java.Util.Date

    @Autowired
    NewsService newsService;

    @ResponseBody
    @RequestMapping("/getNews")
    public List<News> getUsers(){//✔
//        System.out.println("getusers...");
        return newsService.getUsers();
    }
    @ResponseBody
    @RequestMapping("/addNews")
    public int addUser(News u){//✔
        News news = new News("sdjfk1","adf", "title", 99);
        return newsService.addUser(news);
    }
    @ResponseBody
    @RequestMapping("delNews")
    public int delUser(String id){//✔
        return newsService.delUser("adf");
    }
    @ResponseBody
    @RequestMapping("/modNews")
    public int modUser(User u){//改了
        News news = new News("sdjfk1","adf", "改了", 20);
        return newsService.modUser(news);
    }

}
