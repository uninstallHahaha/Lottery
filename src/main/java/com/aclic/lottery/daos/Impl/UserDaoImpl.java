package com.aclic.lottery.daos.Impl;

import com.aclic.lottery.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sun.security.provider.MD5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl {

    @Autowired
    JdbcTemplate jt;

    //查
    public List<User> getUsers() {
        //执行sql
        List users = jt.query("select * from user", new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                User u = new User();
                u.setID(rs.getString("ID"));
                u.setAccount(rs.getString("Account"));
                u.setPassWord(rs.getString("PassWord"));
                u.setRole(rs.getInt("Role"));
                return u;
            }
        });
        return users;
    }

    //增
    public int addUser(User u){
        User user = new User("glic", "123123",1);
        String sql="insert into user (Account,PassWord,Role) values (?,?,?)";
        int count= jt.update(sql, user.getAccount(),user.getPassWord(),user.getRole());
        return count;
    }

    //删
    public int delUser(String id){
        String sql="delete from user where id=?";
        int res= jt.update(sql, id);
        return res;
    }

    //改
    public int modUser(User u){
        String sql="update user set Account=?,PassWord=? where id=?";
        int res = jt.update(sql,u.getAccount(), u.getPassWord(),u.getID());
        return res;
    }
}
