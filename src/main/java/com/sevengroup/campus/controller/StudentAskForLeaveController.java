package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.AskForLeave.LeaveApplicationMsg;
import com.sevengroup.campus.bean.AskForLeave.StudentAskForLeaveInfoBean;
import com.sevengroup.campus.bean.AskForLeave.TeachClassLessonInfoBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.StudentAskForLeaveService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class StudentAskForLeaveController {
    //将Service注入Web层
    @Autowired
    private StudentAskForLeaveService studentAskForLeaveService;

    @RequestMapping("StudentAskForLeave")
    public String showStudentAskForLeave(){
        return "StudentAskForLeave";
    }

    @RequestMapping(value = "/queryTeachClassLessonInfo/{date}")
    public void queryTeachClassLessonInfo(@PathVariable("date") String date, HttpServletResponse resp, HttpServletRequest request){
        try {
            //调取系统用户的username即为studentID
            String studentID = new Tool().getUserID(request);
//            System.out.println("uaername：" + studentID);
            //
            List<TeachClassLessonInfoBean> teachClassLessonInfoList = studentAskForLeaveService.queryTeachClassLessonInfoForStudent(studentID, date);
            Collections.sort(teachClassLessonInfoList, Comparator.comparing(TeachClassLessonInfoBean::getLessonDate));
            /*将list集合转换成json对象*/
            JSONArray data = JSONArray.fromObject(teachClassLessonInfoList);
//            for (int i = 0; i < data.size(); i++){
//                System.out.println(teachClassLessonInfoList.get(i).toString());
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

    @RequestMapping(value = "/insertStudentAskForLeave", method = RequestMethod.POST)
    @ResponseBody
    public String insertStudentAskForLeave(@RequestParam(value = "startDate") String startDate,
                                         @RequestParam(value = "endDate") String endDate,
                                           @RequestParam(value = "reason") String reason,
                                           @RequestParam(value = "date") String date,
                                           HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //调取系统用户的username即为studentID
        String studentID = new Tool().getUserID(request);
        System.out.println("uaername：" + studentID);
//        studentID = "20212031";
        //
        List<TeachClassLessonInfoBean> teachClassLessonInfoList = studentAskForLeaveService.queryTeachClassLessonInfoForStudent(studentID, date);

        List<String> teacherIDList = new ArrayList<>();
        for (int i = 0; i < teachClassLessonInfoList.size(); i++) {
            try {
                Date sDate = new Date(sdf.parse(startDate).getTime());
                Date eDate = new Date(sdf.parse(endDate).getTime());
                Date lessonDate = new Date(sdf.parse(teachClassLessonInfoList.get(i).getLessonDate()).getTime());
                if (sDate.getTime() <= lessonDate.getTime() && lessonDate.getTime() <= eDate.getTime()){
                    String lessonID = teachClassLessonInfoList.get(i).getLessonID();
                    String state = "待审核";
                    StudentAskForLeaveInfoBean studentAskForLeaveInfoBean = new StudentAskForLeaveInfoBean(lessonID, studentID, state, reason);
                    studentAskForLeaveService.insertStudentAskForLeaveInfo(studentAskForLeaveInfoBean);
                    String teacherID = teachClassLessonInfoList.get(i).getTeacherID();
                    if (teacherIDList ==null || !teacherIDList.contains(teacherID)){
                        teacherIDList.add(teacherID);
                        String type = "LeaveApplication";
                        String info = "尊敬的老师，您的学生向您发出了请假申请。";
                        String receiver = teacherID;
                        String sender = studentID;
                        LeaveApplicationMsg leaveApplicationMsg = new LeaveApplicationMsg(type, info, sender, receiver);
                        studentAskForLeaveService.insertLeaveApplicationMsg(leaveApplicationMsg);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", 1);
        jsonResult.put("data", "成功返回");
        return jsonResult.toJSONString();
    }

}
