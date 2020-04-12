package com.aclic.lottery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

@Controller()
public class AvUploadController {

    /**
     * 上传头像
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadAV", method = RequestMethod.POST)
    @ResponseBody
    public String update(String imgBase64,String fileFileName) throws UnsupportedEncodingException {

        imgBase64 = URLDecoder.decode(imgBase64,"UTF-8");
        System.out.println(imgBase64+","+fileFileName);

        imgBase64 = imgBase64.substring(22);

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgBase64);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            //使用uuid使得文件名唯一
            String uuid = UUID.randomUUID().toString().replace("-","").substring(0,6);
            fileFileName = uuid + "_" + fileFileName;

            OutputStream out = new FileOutputStream("/uploads/avatars/"+fileFileName);
            out.write(b);
            out.flush();
            out.close();

        } catch (Exception e) {
            return "false";
        }

        return "hi";
    }
}
