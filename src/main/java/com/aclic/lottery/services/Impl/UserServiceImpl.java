package com.aclic.lottery.services.Impl;

import com.aclic.lottery.daos.Impl.UserDaoImpl;
import com.aclic.lottery.Models.User;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aclic
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDao;

    /**
     *查
     */
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    /**
     *增
     */
    @Override
    public int addUser(User u){
       return userDao.addUser(u);
    }


    /**
     *删
     * @param id
     */
    @Override
    public int delUser(String id){
        return userDao.delUser(id);
    }


    /**
     * 改
     * @param u
     * @return
     */
    @Override
    public int modUser(User u){
        return userDao.modUser(u);
    }
}
