package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ExamForStudentBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.ExamQueryService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class ExamQueryController {
    //将Service注入Web层
    @Autowired
    private ExamQueryService examQueryService;

    @RequestMapping("/examScheduleQueryForStudent")
    public String show(){
        return "examScheduleQueryForStudent";
    }

    @RequestMapping(value = "/examScheduleQuery/{date}")
    public void query(@PathVariable("date") String date, HttpServletResponse resp, HttpServletRequest request){
        try {
            //调取系统用户的username即为studentID
            String studentID = new Tool().getUserID(request);
//            System.out.println("username" + studentID);
            //
            List<ExamForStudentBean> examForStudentBeanList = examQueryService.examQuery(studentID, date);
            /*将list集合转换成json对象*/
            Collections.sort(examForStudentBeanList, Comparator.comparing(ExamForStudentBean::getStartExamTime));//对list按照考试开始时间排序
//            for (int i = 0; i< examForStudentBeanList.size(); i++){
//                System.out.println(examForStudentBeanList.get(i).toString());
//            }
            JSONArray data = JSONArray.fromObject(examForStudentBeanList);
//            for (int i = 0; i< data.size(); i++){
//                System.out.println(examForStudentBeanList.get(i).toString());
//                System.out.println(data.get(i).toString());
//            }
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

}
