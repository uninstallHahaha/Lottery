package com.aclic.lottery.daos;

import com.aclic.lottery.Models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where account=#{account} and password=#{password}")
    public User findOne(User user);

    @Select("select * from user where id=#{id}")
    public User findOneById(String id);


    @Insert("insert into user (id, account, password, role, av) values(#{id}, #{account}, #{password}, #{role}, #{av})")
    public int addUser(User user);

    @Update("update user set account=#{account},password=#{password},role=#{role},av=#{av} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public int delUser(String id);

    //业务
    //signIn
    @Insert("insert into user (id, account, password, role) values(#{id}, #{account}, #{password}, #{role})")
    public int signInUser(User user);

    //active email
    @Update("update user set email=#{email} where id=#{id}")
    public int activeEmail(User user);

    //forget
    @Select("select * from user where account=#{account}")
    public User findOneByName(String account);
}