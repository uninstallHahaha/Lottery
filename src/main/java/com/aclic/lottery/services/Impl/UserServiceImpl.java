package com.aclic.lottery.services.Impl;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.daos.UserDao;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        List<User> userList = userDao.findAll();
        return userList;
    }

    @Override
    public int addUser(User u) {
        return 0;
    }

    @Override
    public int delUser(String id) {
        return 0;
    }

    @Override
    public int modUser(User u) {
        return 0;
    }
}
