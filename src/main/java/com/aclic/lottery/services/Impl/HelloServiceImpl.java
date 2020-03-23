package com.aclic.lottery.services.Impl;

import com.aclic.lottery.services.HelloService;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl  implements HelloService {
    @Override
    public void getStart() {
        System.out.println("hellosevice被调用");
    }
}
