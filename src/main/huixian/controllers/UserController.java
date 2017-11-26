package main.huixian.controllers;

import main.huixian.bean.User;
import main.huixian.service.UserService;
import main.huixian.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import java.io.File;
import java.io.IOException;

/**
 * Created by ASUS on 2017/11/3.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;
    /*
    * 1，通过POST方式传过来的数据，不是写在消息头，而是放在表单之内
    * 2，传过来的文件以二进制格式存储，不能强为字符串形式存在数据中
    * 3，因为是放在表单之内，所以无法通过request.getParameter取得值。\
    *
    * 4，到底是怎样把表单中的参数绑定到User这对象中来的
    * 5，通过参数绑定RequestParam ，可以使变量名跟属性名不一致
    *
    * 6,解决办法，在pom中配置文件上传的依赖包commons-io，commons-fileupload
    *
    * */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request,
                        @RequestParam(value = "file", required = false) MultipartFile file){

        System.out.println("---查看是否进来--");
        String name = request.getParameter("name");
        System.out.println(name+"---");
        System.out.println(file.getOriginalFilename());

        String path = file.getOriginalFilename();
        System.out.println("路径为： "+path);

        try {
            file.transferTo(new File("D:\\" +
                    "1\\pic\\" + path));
        } catch (IOException e) {
            e.printStackTrace();
        }


        String contentType = file.getContentType();
        System.out.println(contentType);
        String imageName = contentType.substring(contentType.indexOf("/") + 1);
        System.out.println(imageName);

        System.out.println(name+"---"+user.getPic()+"---"+user.getName());

        userService.add(user);

        return "login";

    }
}
