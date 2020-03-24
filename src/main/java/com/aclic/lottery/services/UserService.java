package com.aclic.lottery.services;

import com.aclic.lottery.Models.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public int addUser(User u);
    public int delUser(String id);
    public int modUser(User u);
}
