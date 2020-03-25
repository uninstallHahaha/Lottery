package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.Gain;
import com.aclic.lottery.services.GainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Aclic
 */
@Controller
public class GainController {
    @Autowired
    GainService gs;
    @ResponseBody
    @RequestMapping("/getGains")
    public List<Gain> getGains(){
        return gs.getGains();
    }
    @ResponseBody
    @RequestMapping("/addGain")
    public int addGain(Gain g){
        return gs.addGain(g);
    }
    @ResponseBody
    @RequestMapping("/delGain")
    public int delGain(String id){
        return gs.delGain(id);
    }
    @ResponseBody
    @RequestMapping("/modGain")
    public int modGain(Gain g){
        return gs.modGain(g);
    }
}
