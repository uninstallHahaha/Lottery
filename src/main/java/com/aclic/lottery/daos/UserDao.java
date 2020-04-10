package com.aclic.lottery.daos;

import com.aclic.lottery.Models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from user")
    public List<User> findAll();

    @Insert("insert into user (id, account, password, role, av) values(#{id}, #{account}, #{password}, #{role}, #{av})")
    public int addUser(User user);

    @Update("update user set account=#{account},password=#{password},role=#{role},av=#{av} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public int delUser(String id);
}
