package com.aclic.lottery.controllers;

import com.aclic.lottery.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloController{

    @Autowired
    HelloService helloService;

    @RequestMapping(path="/hello")
    public String sayHello(Model model){

        List users = helloService.getStart();
        model.addAttribute("users",users);
        return "success";
    }
}