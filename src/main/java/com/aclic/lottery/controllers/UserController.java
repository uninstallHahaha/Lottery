package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
//        System.out.println("getusers...");
        return userService.getUsers();
    }
    @ResponseBody
    @RequestMapping("/addUser")
    public int addUser(User u){//✔

        User acli = new User("ssss","aaaa","sss",1,"asss");
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
