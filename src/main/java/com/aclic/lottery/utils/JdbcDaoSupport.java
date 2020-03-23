package com.aclic.lottery.utils;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcDaoSupport {

    private JdbcTemplate jt;
    public void setJdbcTemplate(JdbcTemplate jt){
        this.jt = jt;
    }

}
