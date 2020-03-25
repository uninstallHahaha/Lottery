package com.aclic.lottery.daos.Impl;

import com.aclic.lottery.Models.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PrizeDaoImpl {

    @Autowired
    JdbcTemplate jt;

    //查
    public List<Prize> getUsers() {
        //执行sql
        List prizes = jt.query("select * from prize", new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Prize prize = new Prize();
                prize.setID(rs.getString("ID"));
                prize.setName(rs.getString("Name"));
                prize.setDesc(rs.getString("Desc"));
                prize.setPic(rs.getString("Pic"));
                prize.setBigPic(rs.getString("BigPic"));
                prize.setCount(rs.getInt("Count"));
                prize.setProvider(rs.getString("Provider"));
                prize.setState(rs.getInt("State"));
                prize.setCreaTime(rs.getDate("CreaTime"));
                prize.setStartTime(rs.getDate("StartTime"));
                prize.setDuraTime(rs.getInt("DuraTime"));
                return prize;
            }
        });
        return prizes;
    }

    //增
    public int addPrize(Prize p){
        String sql="insert into prize values (?,?,?,?,?,?,?,?,?,?,?)";
        int res= jt.update(sql,
                p.getID(),
                p.getName(),
                p.getDesc(),
                p.getPic(),
                p.getBigPic(),
                p.getCount(),
                p.getProvider(),
                p.getState(),
                p.getCreaTime(),
                p.getStartTime(),
                p.getDuraTime());
        return res;
    }

    //删
    public int delPrize(String id){
        String sql="delete from prize where ID=?";
        int res= jt.update(sql, id);
        return res;
    }

    //改
    public int modPrize(Prize p){
        String sql="update prize set " +
                "Name=?,Desc=?," +
                "Pic=?," +
                "BigPic=?," +
                "Count=?," +
                "Provider=?," +
                "State=?," +
                "CreaTime=?," +
                "StartTime=?," +
                "DuraTime=? where ID=?";
        int res = jt.update(sql,
                p.getName(),
                p.getDesc(),
                p.getPic(),
                p.getBigPic(),
                p.getCount(),
                p.getProvider(),
                p.getState(),
                p.getCreaTime(),
                p.getStartTime(),
                p.getDuraTime());
        return res;
    }
}
