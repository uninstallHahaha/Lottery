package com.aclic.lottery.controllers;

import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Aclic
 */
@Controller
public class UtilsController {

    @Autowired
    UserService userService;

    @RequestMapping("/showEw")
    public String showEw() {
        return "Ew";
    }

    @RequestMapping("/getUploadPage")
    public String getUploadPage() {
        return "upload";
    }

}
