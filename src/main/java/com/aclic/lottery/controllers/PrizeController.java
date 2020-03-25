package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.Prize;
import com.aclic.lottery.services.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Aclic
 */
@Controller
public class PrizeController {

    @Autowired
    PrizeService prizeService;
    @ResponseBody
    @RequestMapping("/getPrizes")
    public List<Prize> getPrizes(){
        return prizeService.getPrizes();
    }
    @ResponseBody
    @RequestMapping("/addPrize")
    public int addPrize(Prize p){
        return prizeService.addPrize(p);
    }
    @ResponseBody
    @RequestMapping("/delPrize")
    public int delPrize(String id){
        return prizeService.delPrize(id);
    }
    @ResponseBody
    @RequestMapping("modPrize")
    public int modPrize(Prize p){
        return prizeService.modPrize(p);
    }
}
