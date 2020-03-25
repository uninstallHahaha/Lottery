package com.aclic.lottery.services.Impl;

import com.aclic.lottery.daos.Impl.GainDaoImpl;
import com.aclic.lottery.Models.Gain;
import com.aclic.lottery.services.GainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aclic
 */
@Service
public class GainServiceImpl implements GainService {

    @Autowired
    GainDaoImpl gainDao;

    /**
     * 查
     * @return
     */
    @Override
    public List<Gain> getGains() {
        return gainDao.getGains();
    }

    /**
     * 增
     * @param g
     * @return
     */
    @Override
    public int addGain(Gain g){
        return gainDao.addGain(g);
    }

    /**
     * 删
     * @param id
     * @return
     */
    @Override
    public int delGain(String id){
        return gainDao.delGain(id);
    }

    /**
     * 改
     * @param g
     * @return
     */
    @Override
    public int modGain(Gain g){
        return gainDao.modGain(g);
    }
}
