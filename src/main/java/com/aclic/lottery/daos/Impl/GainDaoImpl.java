package com.aclic.lottery.daos.Impl;

import com.aclic.lottery.Models.Gain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GainDaoImpl {

    @Autowired
    JdbcTemplate jt;

    //查
    public List<Gain> getGainprizeinfos() {
        //执行sql
        List gainprizeinfos = jt.query("select * from gainprizeinfo", new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Gain gain = new Gain();
                gain.setID(rs.getString("ID"));
                gain.setPrizeID(rs.getString("PrizeID"));
                gain.setUserID(rs.getString("UserID"));
                gain.setUserName(rs.getString("UserName"));
                gain.setGainTime(rs.getDate("GainTime"));
                gain.setAddress(rs.getString("Address"));
                return gain;
            }
        });
        return gainprizeinfos;
    }

    //增
    public int addGainprizeinfo(Gain g){
        String sql="insert into gainprizeinfo values (?,?,?,?,?,?)";
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
    public int delGainprizeinfo(String id){
        String sql="delete from gainprizeinfo where ID=?";
        int res= jt.update(sql, id);
        return res;
    }

    //改
    public int modGainprizeinfo(Gain g){
        String sql="update gainprizeinfo set " +
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
