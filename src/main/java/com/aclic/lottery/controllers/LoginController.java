package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.Utils.Utils;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
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
    public User login(String account, String password, boolean remember, HttpSession session) {
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


}
