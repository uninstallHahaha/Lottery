package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.Utils.Utils;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Aclic
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public int addUser(User u) {//✔
        User acli = new User(Utils.genUUID(), "名字", "sss", 1, "asss");
        return userService.addUser(acli);
    }

    @ResponseBody
    @RequestMapping("delUser")
    public int delUser(String id) {//✔
        return userService.delUser("abc");
    }

    @ResponseBody
    @RequestMapping("/modUser")
    public int modUser(User u) {//
        User acli = new User("abc", "zzz", "23123", 1, "xxx");
        return userService.modUser(acli);
    }

    @ResponseBody
    @RequestMapping("/signIn")
    public int signIn(String account, String pass) {//✔
        String md5Password = DigestUtils.md5DigestAsHex(pass.getBytes());
        User u = new User(Utils.genUUID(), account, md5Password, 1);
        return userService.signInUser(u);
    }

    //show change password
    @RequestMapping("/getChangePassPage")
    public String getChangePassPage() {//✔
        return "CPass";
    }

    //modify password
    @ResponseBody
    @RequestMapping("/modPass")
    public Map<String, Object> modPass(String oldPass, String newPass, String reNewPass, HttpSession session) {//✔
        Map<String, Object> map = new HashMap<String, Object>();
        User curUser = (User) (session.getAttribute("USER_SESSION"));
        if (!DigestUtils.md5DigestAsHex(oldPass.getBytes()).equals(curUser.getPassword())) {
            map.put("res", 0);
            map.put("data", "原密码输入错误,请重新输入");
            return map;
        }
        if (!newPass.equals(reNewPass)) {
            map.put("res", 0);
            map.put("data", "两次输入的新密码不同,请重新输入");
            return map;
        }
        String md5Password = DigestUtils.md5DigestAsHex(newPass.getBytes());
        curUser.setPassword(md5Password);
        if (userService.modUser(curUser) == 1) {
            map.put("res", 1);
            map.put("data", "");
            return map;
        } else {
            map.put("res", 0);
            map.put("data", "服务器异常,请稍后再试");
            return map;
        }
    }
}
