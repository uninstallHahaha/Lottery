package com.aclic.lottery.daos.Impl;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.daos.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HelloDaoImpl implements HelloDao {

//    @Autowired
//    JdbcTemplate jt;

    @Override
    public List<User> getUsers() {
//        //执行sql
//        List users = jt.query("select * from user", new RowMapper() {
//            @Override
//            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//                User u = new User();
//                u.setID(rs.getString("ID"));
//                u.setAccount(rs.getString("Account"));
//                u.setPassWord(rs.getString("PassWord"));
//                u.setRole(rs.getInt("Role"));
//                return u;
//            }
//        });
        return null;
    }
}
