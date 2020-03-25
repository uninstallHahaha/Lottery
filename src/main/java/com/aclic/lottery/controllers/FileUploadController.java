package com.aclic.lottery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller()
public class FileUploadController {

    /**
     * 上传头像
     * @param request
     * @param avatar
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadAvatar")
    public String uploadAvatar(HttpServletRequest request, MultipartFile avatar) throws Exception{
        //获取上传的位置(判断有无, 无责新建)
        String path = request.getSession()
                .getServletContext().getRealPath("/uploads/avatars");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        //获取上传文件的名称
        String filename = avatar.getOriginalFilename();
        //使用uuid使得文件名唯一
        String uuid = UUID.randomUUID().toString().replace("-","").substring(0,6);
        filename = uuid + "_" + filename;
        //文件上传
        avatar.transferTo(new File(path, filename));

        return "success";
    }

    /**
     * 上传商品普通图
     * @param request
     * @param pic
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadPic")
    public String uploadPic(HttpServletRequest request, MultipartFile pic) throws Exception{
        //获取上传的位置(判断有无, 无责新建)
        String path = request.getSession()
                .getServletContext().getRealPath("/uploads/pics");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        //获取上传文件的名称
        String filename = pic.getOriginalFilename();
        //使用uuid使得文件名唯一
        String uuid = UUID.randomUUID().toString().replace("-","").substring(0,6);
        filename = uuid + "_" + filename;
        //文件上传
        pic.transferTo(new File(path, filename));

        return "success";
    }
    /**
     * 上传商品高分辨率图
     * @param request
     * @param bigPic
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadBigPic")
    public String uploadBigPic(HttpServletRequest request, MultipartFile bigPic) throws Exception{
        //获取上传的位置(判断有无, 无责新建)
        String path = request.getSession()
                .getServletContext().getRealPath("/uploads/bigPics");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        //获取上传文件的名称
        String filename = bigPic.getOriginalFilename();
        //使用uuid使得文件名唯一
        String uuid = UUID.randomUUID().toString().replace("-","").substring(0,6);
        filename = uuid + "_" + filename;
        //文件上传
        bigPic.transferTo(new File(path, filename));

        return "success";
    }
}
