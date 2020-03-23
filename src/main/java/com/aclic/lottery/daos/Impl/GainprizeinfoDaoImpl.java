package com.aclic.lottery.daos.Impl;

import com.aclic.lottery.Models.Gainprizeinfo;
import com.aclic.lottery.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GainprizeinfoDaoImpl {

    @Autowired
    JdbcTemplate jt;

    //查
    public List<Gainprizeinfo> getGainprizeinfos() {
        //执行sql
        List gainprizeinfos = jt.query("select * from gainprizeinfo", new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Gainprizeinfo gainprizeinfo = new Gainprizeinfo();
                gainprizeinfo.setID(rs.getString("ID"));
                gainprizeinfo.setPrizeID(rs.getString("PrizeID"));
                gainprizeinfo.setUserID(rs.getString("UserID"));
                gainprizeinfo.setUserName(rs.getString("UserName"));
                gainprizeinfo.setGainTime(rs.getDate("GainTime"));
                gainprizeinfo.setAddress(rs.getString("Address"));
                return gainprizeinfo;
            }
        });
        return gainprizeinfos;
    }

    //增
    public int addGainprizeinfo(Gainprizeinfo g){
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
    public int modGainprizeinfo(Gainprizeinfo g){
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
