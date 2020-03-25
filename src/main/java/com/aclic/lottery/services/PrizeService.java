package com.aclic.lottery.services;

import com.aclic.lottery.Models.Prize;

import java.util.List;

/**
 * @author aclic
 */
public interface PrizeService {
    public List<Prize> getPrizes();
    public int addPrize(Prize p);
    public int delPrize(String id);
    public int modPrize(Prize p);
}
