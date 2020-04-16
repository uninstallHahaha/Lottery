package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.Utils.Utils;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aclic
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/getLoginPage")
    public String getLoginPage() {
        return "Login";
    }

    @RequestMapping("/getSignInPage")
    public String getSignInPage() {
        return "SignIn";
    }

    @ResponseBody
    @RequestMapping("/login")
    public User login(HttpServletRequest request, HttpServletResponse response,
                      String account, String password, String remember, HttpSession session) {
        Cookie cookieName = new Cookie("account",account);
        Cookie cookiePass = new Cookie("pass",password);
        cookieName.setPath(request.getContextPath()+"/");
        cookiePass.setPath(request.getContextPath()+"/");
        if(null != remember && remember.equals("1")){
            cookieName.setMaxAge(7*24*60*60);
            cookiePass.setMaxAge(7*24*60*60);
            response.addCookie(cookieName);
            response.addCookie(cookiePass);
        }else{
            cookieName.setMaxAge(0);
            cookiePass.setMaxAge(0);
            response.addCookie(cookieName);
            response.addCookie(cookiePass);
        }
        //login op
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        User one = userService.findOne(account, md5Password);
        if (one != null) {
            session.setAttribute("USER_SESSION", one);
        }
        return one;
    }

    @ResponseBody
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "1";
    }


    //vue 获取用户登录信息
    @ResponseBody
    @RequestMapping(value = "/getLoginUserInfo")
    public User getLoginUserInfo(HttpSession session) {
        return ((User)session.getAttribute("USER_SESSION"));
    }


    //返回忘记密码页面
    @RequestMapping(value = "/getForgetPage")
    public String getForgetPage(HttpSession session) {
        return "forget";
    }

}
