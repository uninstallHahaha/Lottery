package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.*;
import com.aclic.lottery.Models.compound.CommentMUser;
import com.aclic.lottery.Utils.Utils;
import com.aclic.lottery.services.CommentService;
import com.aclic.lottery.services.NewsService;
import com.aclic.lottery.services.SupportService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Aclic
 */
@Controller
public class NewsController {

    //数据库timestamp , 默认CURRENT_TIMESTAMP
    //model 使用 java.Util.Date

    @Autowired
    NewsService newsService;
    @Autowired
    CommentService commentService;
    @Autowired
    SupportService supportService;

    //crud
    @ResponseBody
    @RequestMapping("/getNews")
    public List<News> getUsers() {
        return newsService.getUsers();
    }

    @ResponseBody
    @RequestMapping("/getOneNews")
    public News getOneNews(String id) {
        return newsService.findOne(id);
    }

    @ResponseBody
    @RequestMapping("/addNews")
    public Map<String, Object> addUser(String title, String body) {
        Map<String, Object> map = new HashMap<>();
        News news = new News(Utils.genUUID(), title, body, 0, 1);
        int res = newsService.addUser(news);
        if (res == 1) {
            map.put("stat", 1);
            map.put("data", "");
        } else {
            map.put("stat", 0);
            map.put("data", "服务器忙,请稍后再试");
        }
        return map;
    }


    @ResponseBody
    @RequestMapping("/addNewsAsScr")
    public Map<String, Object> addNewsAsScr(String title, String body) {
        Map<String, Object> map = new HashMap<>();
        News news = new News(Utils.genUUID(), title, body, 0, 0);
        int res = newsService.addUser(news);
        if (res == 1) {
            map.put("stat", 1);
            map.put("data", "");
        } else {
            map.put("stat", 0);
            map.put("data", "服务器忙,请稍后再试");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("delNews")
    public int delUser(String id) {//✔
        return newsService.delUser(id);
    }

    @ResponseBody
    @RequestMapping("/modNews")
    public int modUser(User u) {//改了
        News news = new News("sdjfk1", "adf", "改了", 20);
        return newsService.modUser(news);
    }

    //初始news
    @RequestMapping("/getNewsPage")
    public String getNewsPage(Model model, HttpSession session) {
        List<News> newsList = newsService.lazyGetNews(0);
        //加载top10 news
        List<News> topNews = newsService.findTopNews();
        model.addAttribute("topNews",topNews);
        //初始化withZan list
        List<NewsWithSupport> newsWithSupports = Utils.newsToWithSupport(newsList);
        //加载用户信息
        User curUser = (User) session.getAttribute("USER_SESSION");
        //newswithsupport 置入 ifsupport 信息
        if (curUser != null) {
            //select relative zan list
            List<Support> seriousByUser = supportService.findSeriousByUser(curUser.getId());
            for (Support s : seriousByUser) {
                for (NewsWithSupport newsWithSupport : newsWithSupports) {
                    //置入zan list
                    if (s.getNewsid().equals(newsWithSupport.getId())) {
                        newsWithSupport.setIfSupport(true);
                        break;
                    }
                }
            }
        }
        model.addAttribute("newsList", newsWithSupports);
        return "news";
    }


    //懒加载
    @ResponseBody
    @RequestMapping("/lazyGetNews")
    public List<NewsWithSupport> lazyGetNews(int start, HttpSession session) {
        //初始化带zan类型的列表
        List<News> newsList = newsService.lazyGetNews(start);
        List<NewsWithSupport> newsWithSupports = Utils.newsToWithSupport(newsList);
        //加载用户信息
        User curUser = (User) session.getAttribute("USER_SESSION");
        //newswithsupport 置入 ifsupport 信息
        if (curUser != null) {
            //select relative zan list
            List<Support> seriousByUser = supportService.findSeriousByUser(curUser.getId());
            for (Support s : seriousByUser) {
                for (NewsWithSupport newsWithSupport : newsWithSupports) {
                    //置入zan list
                    if (s.getNewsid().equals(newsWithSupport.getId())) {
                        newsWithSupport.setIfSupport(true);
                        break;
                    }
                }
            }
        }
        return newsWithSupports;
    }

    //newsDetail
    @RequestMapping("/getNewsDetail")
    public String getNewsDetail(Model model, String newsId, HttpSession session) {
        //newsDetail
        News newsInfo = newsService.findOne(newsId);
        NewsWithSupport newsWithSupport = new NewsWithSupport(
                newsInfo.getId(),
                newsInfo.getTitle(),
                newsInfo.getContent(),
                newsInfo.getZan(),
                newsInfo.getCreatetime(),
                false
        );
        Object user_session = session.getAttribute("USER_SESSION");
        if (user_session != null) {
            String userId = ((User) user_session).getId();
            List<Support> seriousByUser = supportService.findSeriousByUser(userId);
            for (Support s : seriousByUser) {
                if (s.getNewsid().equals(newsId)) {
                    //点过赞
                    newsWithSupport.setIfSupport(true);
                    break;
                }
            }
        }
        model.addAttribute("news", newsWithSupport);
        //relative comments
        List<CommentMUser> comments = commentService.findSeriousMUserByNews(newsId);
        model.addAttribute("comments", comments);
        return "newsDetail";
    }

    //返回草稿箱页
    @RequestMapping("/getScrsPage")
    public String getScrsPage(Model model, HttpSession session) {
        model.addAttribute("scrs",newsService.findAllScrs());
        return "scrsPage";
    }

}