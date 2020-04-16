package com.aclic.lottery.services;

import com.aclic.lottery.Models.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> getUsers();
    public User findOne(String account, String pass);
    public int addUser(User u);
    public int delUser(String id);
    public int modUser(User u);

    public int signInUser(User user);

    public int activeEmail(User user);

    public User findOneByName(String account);

    public User findOneById(String id);


}
