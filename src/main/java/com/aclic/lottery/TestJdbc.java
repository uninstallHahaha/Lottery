package com.aclic.lottery;

import com.aclic.lottery.Models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.DigestUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class TestJdbc {

    public static void testJDBC(String[] args) {
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
                User u = new User("","");
                u.setId(rs.getString("ID"));
                u.setAccount(rs.getString("Account"));
                u.setPassword(rs.getString("PassWord"));
                u.setRole(rs.getInt("Role"));
                return u;
            }
        });
        for (User u :
                users) {
            System.out.println(u);
        }

    }

    public static void rand(String[] args) {
        String uuid = UUID.randomUUID().toString().substring(0,28);
        System.out.println(uuid);
    }

    public static void main(String[] args) {
        String md5Password = DigestUtils.md5DigestAsHex("123".getBytes());
        System.out.println(md5Password.length());
    }
}
