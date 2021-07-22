package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.AskForLeave.LeaveApplicationMsg;
import com.sevengroup.campus.bean.AskForLeave.StudentAskForLeaveInfoBean;
import com.sevengroup.campus.bean.AskForLeave.TeachClassLessonInfoBean;
import com.sevengroup.campus.bean.ScoreForStudentBean;
import com.sevengroup.campus.bean.StudentApplicationClassroomBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.StudentApplicationClassroomService;
import com.sevengroup.campus.service.StudentAskForLeaveService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class StudentApplicationClassroomController {

    //将Service注入Web层
    @Autowired
    private StudentApplicationClassroomService studentApplicationClassroomService;

    @Autowired
    private StudentAskForLeaveService studentAskForLeaveService;

    @RequestMapping("/studentApplicationClassroom")
    public String show(){
        return "studentApplicationClassroom";
    }

    @RequestMapping("/studentApplicationClassroom/queryClassroomID")
    public void queryClassroomID(HttpServletResponse resp){
        try {
            List classroomIDList = studentApplicationClassroomService.queryClassroomID();
//            for (int i = 0; i < classroomIDList.size(); i++){
//                System.out.println(classroomIDList.get(i).toString());
//            }
            /*将list集合转换成json对象*/
            JSONArray data = JSONArray.fromObject(classroomIDList);
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

    @RequestMapping(value = "/studentApplicationClassroom/insertStudentApplicationClassroom", method = RequestMethod.POST)
    @ResponseBody
    public String insertStudentAskForLeave(@RequestParam(value = "classroomID") String classroomID,
                                           @RequestParam(value = "date") String date,
                                           @RequestParam(value = "selectedSection") String selectedSection,
                                           @RequestParam(value = "description") String description,
                                           HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //调取系统用户的username即为studentID
        String studentID = new Tool().getUserID(request);
//        System.out.println("uaername：" + studentID);
//        studentID = "20212031";

        System.out.println(selectedSection);
        String[] sectionArr = selectedSection.split(",");
        List<Integer> sectionNumberList = new ArrayList<>();
        try {
            Date sectionDate = new Date(sdf.parse(date).getTime());
            for (int i = 0; i < sectionArr.length; i++){
                String section = "";
                switch (Integer.parseInt(sectionArr[i])){
                    case 1:
                        section += "第一节";
                        break;
                    case 2:
                        section += "第二节";
                        break;
                    case 3:
                        section += "第三节";
                        break;
                    case 4:
                        section += "第四节";
                        break;
                    case 5:
                        section += "第五节";
                        break;
                    case 6:
                        section += "第六节";
                        break;
                    case 7:
                        section += "第七节";
                        break;
                    case 8:
                        section += "第八节";
                        break;
                    case 9:
                        section += "第九节";
                        break;
                    case 10:
                        section += "第十节";
                        break;
                    case 11:
                        section += "第十一节";
                        break;
                    case 12:
                        section += "第十二节";
                        break;
                    default:
                }
                String checkApplication = "待审核";
                StudentApplicationClassroomBean studentApplicationClassroomBean = new StudentApplicationClassroomBean(classroomID, date, section, studentID, checkApplication);
                studentApplicationClassroomService.insertApplicationClassroom(studentApplicationClassroomBean);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String type = "ClassroomApplication";
        String info = "尊敬的教室管理员，您收到了一份教室申请。";
        String receiver = "sys";
        String sender = studentID;
        LeaveApplicationMsg leaveApplicationMsg = new LeaveApplicationMsg(type, info, sender, receiver);
        studentAskForLeaveService.insertLeaveApplicationMsg(leaveApplicationMsg);

        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", 1);
        jsonResult.put("data", "成功返回");
        return jsonResult.toJSONString();
    }
}
