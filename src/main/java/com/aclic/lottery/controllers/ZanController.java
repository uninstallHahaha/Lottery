package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.News;
import com.aclic.lottery.Models.Support;
import com.aclic.lottery.Models.User;
import com.aclic.lottery.Utils.Utils;
import com.aclic.lottery.services.NewsService;
import com.aclic.lottery.services.SupportService;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aclic
 */
@Controller
public class ZanController {

    @Autowired
    SupportService supportService;
    @Autowired
    NewsService newsService;

    @ResponseBody
    @RequestMapping("/zanAdd")
    public Map<String, Object> zanAdd(String newsid, HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        if (session.getAttribute("USER_SESSION") == null) {
            map.put("res", 0);
            map.put("data", "还未登录");
            return map;
        }
        User curUser = (User) session.getAttribute("USER_SESSION");
        Support support = new
                Support(Utils.genUUID(),
                curUser.getId(),
                newsid);
        //support 添加记录
        int insertRes = supportService.addSupport(support);
        News oldNews = newsService.findOne(support.getNewsid());
        oldNews.setZan(oldNews.getZan() + 1);
        //news 修改记录
        newsService.modUser(oldNews);
        if (insertRes == 1) {
            map.put("res", 1);
            map.put("data", oldNews.getZan());
            return map;
        } else {
            map.put("res", 0);
            map.put("data", "服务器异常,请稍后再试");
            return map;
        }
    }


    @ResponseBody
    @RequestMapping("/zanMinus")
    public Map<String, Object> zanMinus(String newsid, HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        if (session.getAttribute("USER_SESSION") == null) {
            map.put("res", 0);
            map.put("data", "还未登录");
            return map;
        }
        User curUser = (User) session.getAttribute("USER_SESSION");
        List<Support> seriousByUser = supportService.findSeriousByUser(curUser.getId());
        String supportId = "";
        for (Support support : seriousByUser) {
            if (support.getNewsid().equals(newsid)) {
                supportId = support.getId();
                break;
            }
        }
        int delRes = supportService.delSupport(supportId);

        if (delRes == 1) {
            //news 同步赞同数
            News oldNews = newsService.findOne(newsid);
            oldNews.setZan(oldNews.getZan() - 1);
            int modNewsRes = newsService.modUser(oldNews);
            if (modNewsRes == 1) {
                map.put("res", 1);
                map.put("data", oldNews.getZan());
                return map;
            }
        }

        //异常
        map.put("res", 0);
        map.put("data", "服务器异常,请稍后再试");
        return map;
    }


}
