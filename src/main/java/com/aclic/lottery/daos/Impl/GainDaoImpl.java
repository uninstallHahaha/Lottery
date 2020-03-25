package com.aclic.lottery.daos.Impl;

import com.aclic.lottery.Models.Gain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GainDaoImpl {

    @Autowired
    JdbcTemplate jt;

    //查
    public List<Gain> getGains() {
        //执行sql
        List gains = jt.query("select * from gain", new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Gain gain = new Gain();
                gain.setID(rs.getString("ID"));
                gain.setPrizeID(rs.getString("PrizeID"));
                gain.setUserID(rs.getString("UserID"));
                gain.setUserName(rs.getString("UserName"));
                gain.setGainTime(rs.getTimestamp("GainTime").getTime());
                gain.setAddress(rs.getString("Address"));
                return gain;
            }
        });
        return gains;
    }

    //增
    public int addGain(Gain g){
        String sql="insert into gain values (?,?,?,?,?,?)";
        int res= jt.update(sql,
                g.getID(),
                g.getPrizeID(),
                g.getUserID(),
                g.getUserName(),
                g.getGainTime(),
                g.getAddress());
        return res;
    }

    //删
    public int delGain(String id){
        String sql="delete from gain where ID=?";
        int res= jt.update(sql, id);
        return res;
    }

    //改
    public int modGain(Gain g){
        String sql="update gain set " +
                "PrizeID=?,UserID=?,UserName=?,GainTime=?,Address=? where ID=?";
        int res = jt.update(sql,
                g.getPrizeID(),
                g.getUserID(),
                g.getUserName(),
                g.getGainTime(),
                g.getAddress());
        return res;
    }
}
