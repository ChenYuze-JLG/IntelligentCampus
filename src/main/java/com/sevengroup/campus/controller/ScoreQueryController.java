package com.sevengroup.campus.controller;


import com.sevengroup.campus.bean.ScoreForStudentBean;
import com.sevengroup.campus.service.ScoreService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ScoreQueryController {
    //将Service注入Web层
    @Autowired
    ScoreService scoreService;

    @RequestMapping("/scoreQueryForStudent")
    public String show(){
        return "scoreQueryForStudent";
    }

    @RequestMapping(value = "/queryScoreForStudent/{date}")
    public void query(@PathVariable("date") String date, HttpServletResponse resp){
        try {
            List<ScoreForStudentBean> scoreBeanList = scoreService.scoreSelect("20219834", date);
            /*将list集合转换成json对象*/
            JSONArray data = JSONArray.fromObject(scoreBeanList);
            //接下来发送数据
            /*设置编码，防止出现乱码问题*/
            resp.setCharacterEncoding("utf-8");
            /*得到输出流*/
            PrintWriter respWriter = resp.getWriter();
            /*将JSON格式的对象toString()后发送*/
            respWriter.append(data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @RequestMapping("/queryScore")
//    public void query(HttpServletResponse resp){
//        try {
//            List<ScoreBean> scoreBeanList = scoreService.scoreSelect("20219834");
//            System.out.println(scoreBeanList.size());
//            /*将list集合转换成json对象*/
//            JSONArray data = JSONArray.fromObject(scoreBeanList);
//            //接下来发送数据
//            /*设置编码，防止出现乱码问题*/
//            resp.setCharacterEncoding("utf-8");
//            /*得到输出流*/
//            PrintWriter respWriter = resp.getWriter();
//            /*将JSON格式的对象toString()后发送*/
//            respWriter.append(data.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
