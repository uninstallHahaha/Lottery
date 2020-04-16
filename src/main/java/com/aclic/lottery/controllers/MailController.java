package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.Utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    //send text
    @ResponseBody
    @RequestMapping("send")
    public int sendEmail(HttpSession session,
                            String to) {
        User user = (User) session.getAttribute("USER_SESSION");
        String cont = "";
        cont += "你好!请将该链接复制到浏览器打开以完成激活 localhost:8080/checkIn/"
                +to
                +"/"+user.getId();
        MailUtil mailUtil = new MailUtil();
        int sendRes = mailUtil.sendMail(cont, "Buser",
                to,
                javaMailSender);
        return sendRes;
    }


    @RequestMapping("getEmailPage")
    public String getEmailPage(HttpSession session, Model model) {
        User user = (User)session.getAttribute("USER_SESSION");
        model.addAttribute("curEmail",
                user.getEmail().equals("null@null.com")?"您还未绑定邮箱"
                        :"当前绑定的邮箱:" + user.getEmail());
        return "emailPage";
    }
}
