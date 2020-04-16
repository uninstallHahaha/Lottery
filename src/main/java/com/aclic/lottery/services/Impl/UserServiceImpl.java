package com.aclic.lottery.services.Impl;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.daos.UserDao;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public User findOne(String account, String pass) {
        User user = new User(account, pass);
        return userDao.findOne(user);
    }

    @Override
    public int addUser(User u) {
        return userDao.addUser(u);
    }

    @Override
    public int delUser(String id) {
        return userDao.delUser(id);
    }

    @Override
    public int modUser(User u) {
        return userDao.updateUser(u);
    }

    @Override
    public int signInUser(User user) {
        return userDao.signInUser(user);
    }

    @Override
    public int activeEmail(User user) {
        return userDao.activeEmail(user);
    }

    @Override
    public User findOneByName(String account) {
        return userDao.findOneByName(account);
    }

    @Override
    public User findOneById(String id) {
        return userDao.findOneById(id);
    }


}
