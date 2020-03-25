package com.aclic.lottery.services;

import com.aclic.lottery.Models.Gain;

import java.util.List;

public interface GainService {
    public List<Gain> getGains();
    public int addGain(Gain g);
    public int delGain(String id);
    public int modGain(Gain g);
}
