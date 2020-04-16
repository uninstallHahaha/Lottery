package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.User;
import com.aclic.lottery.Utils.Utils;
import com.aclic.lottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Aclic
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public int addUser(User u) {//✔
        User acli = new User(Utils.genUUID(), "名字", "sss", 1, "asss");
        return userService.addUser(acli);
    }

    @ResponseBody
    @RequestMapping("delUser")
    public int delUser(String id) {//✔
        return userService.delUser(id);
    }

    @ResponseBody
    @RequestMapping("/modUser")
    public int modUser(User u) {//
        return userService.modUser(u);
    }

    @ResponseBody
    @RequestMapping("/signIn")
    public Map<String,Object> signIn(String account, String pass) {//✔
        Map<String, Object> map = new HashMap<String, Object>();
        //judge if exist
        User ifUser = userService.findOneByName(account);
        if(ifUser!=null){
            map.put("stat",0);
            map.put("data","用户名已被占用,换一个试试");
            return map;
        }
        String md5Password = DigestUtils.md5DigestAsHex(pass.getBytes());
        User u = new User(Utils.genUUID(), account, md5Password, 1);
        if(userService.signInUser(u)==1){
            map.put("stat",1);
            map.put("data","注册成功");
        }else{
            map.put("stat",0);
            map.put("data","注册失败,请稍后再试");
        }
        return map;
    }

    //show change password
    @RequestMapping("/getChangePassPage")
    public String getChangePassPage() {//✔
        return "CPass";
    }

    //modify password
    @ResponseBody
    @RequestMapping("/modPass")
    public Map<String, Object> modPass(String oldPass, String newPass, String reNewPass, HttpSession session) {//✔
        Map<String, Object> map = new HashMap<String, Object>();
        User curUser = (User) (session.getAttribute("USER_SESSION"));
        if (!DigestUtils.md5DigestAsHex(oldPass.getBytes()).equals(curUser.getPassword())) {
            map.put("res", 0);
            map.put("data", "原密码输入错误,请重新输入");
            return map;
        }
        if (!newPass.equals(reNewPass)) {
            map.put("res", 0);
            map.put("data", "两次输入的新密码不同,请重新输入");
            return map;
        }
        String md5Password = DigestUtils.md5DigestAsHex(newPass.getBytes());
        curUser.setPassword(md5Password);
        if (userService.modUser(curUser) == 1) {
            map.put("res", 1);
            map.put("data", "");
            return map;
        } else {
            map.put("res", 0);
            map.put("data", "服务器异常,请稍后再试");
            return map;
        }
    }


    @ResponseBody
    @RequestMapping("signout")
    public Map<String, Object> signout(HttpSession session,
                                       HttpServletRequest request, HttpServletResponse response,
                                       String pass) {
        Map<String, Object> map = new HashMap<>();
        User user_session = (User) session.getAttribute("USER_SESSION");
        if (user_session != null &&
                user_session.getPassword().equals(DigestUtils.md5DigestAsHex(pass.getBytes()))) {
            int delRes = this.delUser(user_session.getId());
            if (delRes == 1) {
                map.put("stat", 1);
                map.put("data", "");
                Cookie cookieName = new Cookie("account", "");
                Cookie cookiePass = new Cookie("pass", "");
                cookieName.setPath(request.getContextPath() + "/");
                cookiePass.setPath(request.getContextPath() + "/");
                cookieName.setMaxAge(0);
                cookiePass.setMaxAge(0);
                response.addCookie(cookieName);
                response.addCookie(cookiePass);
                session.invalidate();
            } else {
                map.put("stat", 0);
                map.put("data", "注销失败,请稍后再试");
            }
        } else {
            map.put("stat", 0);
            map.put("data", "密码错误");
        }
        return map;
    }


    @ResponseBody
    @RequestMapping("/modAv")
    public Map<String, Object> modAv(String av, HttpSession session) {//✔
        Map<String, Object> map = new HashMap<>();
        User user = (User) session.getAttribute("USER_SESSION");
        user.setAv(new String("/uploads/avatars/").concat(av));
        int res = modUser(user);
        if (res == 1) {
            map.put("stat", 1);
            map.put("data", "");
        } else {
            map.put("stat", 0);
            map.put("data", "上传失败,请稍后再试");
        }
        return map;
    }


    //绑定邮箱
    @RequestMapping("/checkIn/{email}/{id}")
    public String checkIn(@PathVariable(name = "id") String id,
                          @PathVariable(name = "email") String email,
                          HttpSession session, Model model) {
        User user = new User(email);
        user.setId(id);
        int res = userService.activeEmail(user);
        if (res == 1) {
            //更新session
            User newUser = userService.findOneById(id);
            session.setAttribute("USER_SESSION", newUser);
            model.addAttribute("result", "激活成功!");
        } else {
            model.addAttribute("result", "激活失败,请重新设置邮箱");
        }
        return "checkInRes";
    }
}
