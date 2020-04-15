package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.Support;
import com.aclic.lottery.Models.User;
import com.aclic.lottery.Models.compound.CommentMNews;
import com.aclic.lottery.Models.compound.SupportMNews;
import com.aclic.lottery.services.CommentService;
import com.aclic.lottery.services.SupportService;
import com.aclic.lottery.services.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Aclic
 */
@Controller
public class PCenterController {

    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Autowired
    SupportService supportService;

    @RequestMapping(value = "/toPCenter")
    public String toPCenter(HttpSession session,
                            HttpServletRequest request,HttpServletResponse response,
                            Model model)
            throws Exception {
        User user = (User) session.getAttribute("USER_SESSION");
        if(null == user){
            return "index";
        }
        if(user.getRole() == 2){
            request.getRequestDispatcher("/WEB-INF/pages/manage.html")
                    .forward(request,response);
            return null;
        }
        List<CommentMNews> commentsByUser = commentService.findSeriousMNewsByUser(user.getId());
        List<SupportMNews> seriousMNewsByUser = supportService.findSeriousMNewsByUser(user.getId());
        model.addAttribute("comments",commentsByUser);
        model.addAttribute("supports",seriousMNewsByUser);
        return "pCenter";
    }


}
