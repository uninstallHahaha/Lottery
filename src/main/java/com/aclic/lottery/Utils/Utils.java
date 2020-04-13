package com.aclic.lottery.Utils;

import com.aclic.lottery.Models.News;
import com.aclic.lottery.Models.NewsWithSupport;
import com.aclic.lottery.Models.Support;
import com.aclic.lottery.Models.User;
import com.aclic.lottery.services.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Utils {


    public static String genUUID(){
        return UUID.randomUUID().toString().substring(0,28);
    }

    //news 转 newswithsupport
    public static List<NewsWithSupport> newsToWithSupport(List<News> newsList){
        List<NewsWithSupport> newsWithSupports = new ArrayList<NewsWithSupport>();
        for (News news : newsList) {
            NewsWithSupport newsWithSupport = new NewsWithSupport(
                    news.getId(),
                    news.getTitle(),
                    news.getContent(),
                    news.getZan(),
                    news.getCreatetime(),
                    false);
            newsWithSupports.add(newsWithSupport);
        }
        return newsWithSupports;
    }

}
