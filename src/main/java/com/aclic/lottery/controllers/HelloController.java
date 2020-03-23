package com.aclic.lottery.controllers;

import com.aclic.lottery.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController{

    @Autowired
    HelloService helloService;

    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("controller...");
        helloService.getStart();

        return "success";
    }
}