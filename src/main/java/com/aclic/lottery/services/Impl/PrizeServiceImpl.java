package com.aclic.lottery.services.Impl;

import com.aclic.lottery.daos.Impl.PrizeDaoImpl;
import com.aclic.lottery.Models.Prize;
import com.aclic.lottery.services.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aclic
 */
@Service
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    PrizeDaoImpl prizeDao;

    /**
     *查
     * @return
     */
    @Override
    public List<Prize> getPrizes() {
        return prizeDao.getUsers();
    }

    /**
     *增
     * @return
     */
    @Override
    public int addPrize(Prize p){
        return prizeDao.addPrize(p);
    }

    /**
     *删
     * @return
     */
    @Override
    public int delPrize(String id){
        return prizeDao.delPrize(id);
    }

    /**
     *改
     * @return
     */
    @Override
    public int modPrize(Prize p){
        return prizeDao.modPrize(p);
    }
}
