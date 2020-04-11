package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.Utils.Utils;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @ResponseBody
    @RequestMapping("/addUser")
    public int addUser(User u){//✔
        User acli = new User(Utils.genUUID(),"名字","sss",1,"asss");
        return userService.addUser(acli);
    }
    @ResponseBody
    @RequestMapping("delUser")
    public int delUser(String id){//✔
        return userService.delUser("abc");
    }
    @ResponseBody
    @RequestMapping("/modUser")
    public int modUser(User u){//
        User acli = new User("abc","zzz","23123", 1,"xxx");
        return userService.modUser(acli);
    }

}
