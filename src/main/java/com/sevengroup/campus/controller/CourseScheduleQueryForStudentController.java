package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.CourseForStudentBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.CourseScheduleQueryForStudentService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CourseScheduleQueryForStudentController {

    //将Service注入Web层
    @Autowired
    private CourseScheduleQueryForStudentService courseScheduleQueryForStudentService;

    @RequestMapping("/courseSheduleQueryForStudent")
    public String show(){
        return "courseSheduleQueryForStudent";
    }

    @RequestMapping("/courseSheduleQueryForStudent/queryCourseInfoForStudent/{date}")
    public void queryCourseInfoForStudent(@PathVariable("date") String date, HttpServletResponse resp, HttpServletRequest request){
        try {
            //调取系统用户的username即为studentID
            String studentID = new Tool().getUserID(request);
//            System.out.println("username："+studentID);
            //
            List<CourseForStudentBean> courseForStudentBeanList = courseScheduleQueryForStudentService.queryCourseInfoForStudent(studentID, date);
            /*将list集合转换成json对象*/
//            Collections.sort(courseForStudentBeanList, Comparator.comparing(CourseForStudentBean::getLessonDate));//对list按照上课开始时间排序
            JSONArray data = JSONArray.fromObject(courseForStudentBeanList);
//            for (int i = 0; i< data.size(); i++){
//                System.out.println(courseForStudentBeanList.get(i).toString());
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

    @RequestMapping("/courseSheduleQueryForStudent/addDate/{date}")
    public void addDate(@RequestParam(required = false)String oldDate,
                        @RequestParam(required = false)int days,
                        HttpServletResponse resp){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = new java.sql.Date(sdf.parse(oldDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newDate.setDate(newDate.getDate() + days);
        System.out.println(oldDate);
        System.out.println(newDate);
        int year, month, day;
        year = newDate.getYear();
        month =  newDate.getMonth();
        day = newDate.getDate();
        List<Integer> resultDate = null;
        resultDate.add(year);
        resultDate.add(month);
        resultDate.add(day);
        JSONArray data = JSONArray.fromObject(resultDate);
        for (int i = 0; i< data.size(); i++){
            System.out.println(data.get(i).toString());
        }
        //接下来发送数据
        /*设置编码，防止出现乱码问题*/
        resp.setCharacterEncoding("utf-8");
        /*得到输出流*/
        PrintWriter respWriter = null;
        try {
            respWriter = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*将JSON格式的对象toString()后发送*/
        respWriter.append(data.toString());
    }


}
