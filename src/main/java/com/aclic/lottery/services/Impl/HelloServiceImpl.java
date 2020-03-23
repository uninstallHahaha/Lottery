package com.aclic.lottery.services.Impl;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.daos.HelloDao;
import com.aclic.lottery.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("helloService")
public class HelloServiceImpl  implements HelloService {

    @Autowired
    HelloDao helloDao;

    @Override
    public List<User> getStart() {
        List<User> users = helloDao.getUsers();
        return users;
    }
}
