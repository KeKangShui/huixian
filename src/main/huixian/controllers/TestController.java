package main.huixian.controllers;


import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/11/8.
 */

public class TestController extends HttpServlet {

    static List<String> datas = new ArrayList<String>();
    static {
        /*这些是模拟数据*/

        datas.add("ajax");
        datas.add("ajax form");
        datas.add("ajax submit");
        datas.add("ajax post");
        datas.add("bill");
        datas.add("ball");
        datas.add("baskboll");
        datas.add("butter");

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("fu---ck");
        /*首先获得客户端发送过来*/
        String keyword =request.getParameter("keyword");
        /*获得关键字之后进行处理，得到关联数据*/
        List<String> listData = getDatas(keyword);
        /*返回json 格式*/
//        JSONArray.fromObject(listData);
        System.out.println(JSONArray.fromObject(listData));
        response.getWriter().write(JSONArray.fromObject(listData).toString());
    }

    /*获得关联数据的方法*/
    public List <String> getDatas(String keyword){
        List <String> list =new ArrayList<String>();
        for (String data :datas) {
            if (data.contains(keyword)){
                list.add(data);
            }
        }
        return list;
    }
}
