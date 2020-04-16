package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.Utils.MailUtil;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MailController {

    @Autowired
    private UserService userService;

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
                + to
                + "/" + user.getId();
        MailUtil mailUtil = new MailUtil();
        int sendRes = mailUtil.sendMail(cont, "Buser",
                to,
                javaMailSender);
        return sendRes;
    }


    @RequestMapping("getEmailPage")
    public String getEmailPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("USER_SESSION");
        model.addAttribute("curEmail",
                user.getEmail().equals("null@null.com") ? "您还未绑定邮箱"
                        : "当前绑定的邮箱:" + user.getEmail());
        return "emailPage";
    }


    //sendForget
    @ResponseBody
    @RequestMapping("sendForget")
    public Map<String,Object> sendForget(
            String acc) {
        Map<String, Object> map = new HashMap<>();

        User user = userService.findOneByName(acc);
        if (user != null && !user.getEmail().equals("null@null.com")) {
            String cont = "";
            cont += "你好!" + acc + ",您的密码是" + user.getPassword() + ",请妥善保管.";
            MailUtil mailUtil = new MailUtil();
            int sendRes = mailUtil.sendMail(cont, "密码找回",
                    user.getEmail(),
                    javaMailSender);
            map.put("stat",1);
            map.put("data","");
            return map;
        }else{
            map.put("stat",0);
            map.put("data","该账号不存在或未绑定邮箱");
            return map;
        }
    }
}
