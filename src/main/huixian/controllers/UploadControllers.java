package main.huixian.controllers;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by ASUS on 2017/11/6.
 */
@Controller
public class UploadControllers {

    @RequestMapping(value = "/uploadPic.do", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        System.out.println("查看是否进来  …………………&……");
        System.out.println(file.getOriginalFilename());

        /*把文件存到本地文件夹*/
        if (!file.isEmpty()) {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:\\" +
                    "1\\pic\\" + System.currentTimeMillis() + file.getOriginalFilename()));
        } else {
            System.out.println("保存失败");
        }
        return "index";
    }

    /*为什么页面没进来*/
    @RequestMapping(value = "/getpic")
    @ResponseBody
    public String getpic(HttpServletResponse response, @RequestParam(value = "file", required = false) MultipartFile file) {
        System.out.println("……&……");
//        String na =file.getOriginalFilename();
//        System.out.println(na);
        return "123";
    }

}
