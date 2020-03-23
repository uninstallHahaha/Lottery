package com.aclic.lottery;

import com.aclic.lottery.Models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestJdbc {

    public static void main(String[] args) {
        //创建数据源(连接池)
        //之前使用的是c3p0连接池
        //这里使用DriverManagerDataSource, 是spring内置的一个连接池对象
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/lottery");
        ds.setUsername("root");
        ds.setPassword("123123");

        //创建模板对象
        JdbcTemplate jt = new JdbcTemplate(ds);
        //执行sql
        List<User> users = jt.query("select * from user", new RowMapper(){
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
        for (User u :
                users) {
            System.out.println(u);
        }

    }
}
