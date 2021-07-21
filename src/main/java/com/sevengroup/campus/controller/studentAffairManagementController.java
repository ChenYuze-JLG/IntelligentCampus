package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.TeacherCourseScheduleBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.HeadService;
import com.sevengroup.campus.service.TeachAffairManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class studentAffairManagementController {

    @Autowired
    TeachAffairManageService teachAffairManageService;

    @Autowired
    Tool tool;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HeadService headService;

    private String teacherID;

    // 获取登录用户ID
    public void getTeacherID() {
        teacherID = tool.getUserID(request);
        System.out.println("teacherID: " + teacherID);
    }


    @RequestMapping("/studentAffairManagement")
    public String show(Map<String, Object> map){
        headService.showHeadInfo(map);
        getTeacherID();
        return "teachAffairManagementForStudent";
    }

    // 使用iframe插入的显示课程安排页面
    @RequestMapping("/teachAffairManagementForStudent/CourseScheduleQuery")
    public String showViewCourseSchedule() {
        return "CourseScheduleQueryForTeacher";
    }

    // 教师查询课表
    @RequestMapping(value = "/teachAffairManagementForStudent/getCourseScheduleJSON", method = RequestMethod.POST)
    @ResponseBody
    public String getCourseScheduleForTeacher(
//            @RequestParam(value = "teacherID") String teacherID // 当前数据表格的页数
    ) throws ParseException {
        List<TeacherCourseScheduleBean> teacherCourseSchedule = teachAffairManageService.getStudentCourseSchedule(teacherID);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = getFirstDay(), currDate = getFirstDay();
        List<List<String>> courseSchedule = new ArrayList<>();
        List<List<String>> TCNameInfo = new ArrayList<>();
        List<List<String>> lessonDateInfo = new ArrayList<>();
        List<List<String>> TCStartDateInfo = new ArrayList<>();
        List<List<String>> TCEndDateInfo = new ArrayList<>();
        System.out.println(dateFormat.format(firstDate));
        for (TeacherCourseScheduleBean teacherCourseScheduleBean : teacherCourseSchedule) {
            List<String> courseScheduleDay = Arrays.asList("", "", "", "", "", "", "", "", "", "", "", "");
            Date readDate = dateFormat.parse(teacherCourseScheduleBean.getLessonDate());
            long currDateTime = currDate.getTime();
            long readDateTime = readDate.getTime();
            int days = (int) ((readDateTime - currDateTime) / (1000 * 60 * 60 * 24));
            if (days < 0) continue;
            if (days == 0) {
                switchLessonSection(courseSchedule, TCNameInfo, lessonDateInfo,
                        TCStartDateInfo, TCEndDateInfo, teacherCourseScheduleBean);
                continue;
            }
            while (days > 0) {
                addEmptyList(courseSchedule, TCNameInfo, lessonDateInfo, TCStartDateInfo, TCEndDateInfo);
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(currDate);
                calendar.add(Calendar.DATE, 1); //把日期往后增加一天,整数  往后推,负数往前移动
                currDate = calendar.getTime();
                currDateTime = currDate.getTime();
                days = (int) (Math.ceil(readDateTime - currDateTime) / (1000 * 60 * 60 * 24));
            }
            addEmptyList(courseSchedule, TCNameInfo, lessonDateInfo, TCStartDateInfo, TCEndDateInfo);
            switchLessonSection(courseSchedule, TCNameInfo, lessonDateInfo,
                    TCStartDateInfo, TCEndDateInfo, teacherCourseScheduleBean);
        }
        System.out.println(teacherCourseSchedule.get(0).toString());
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 1);
        jsonResult.put("courseSchedule", courseSchedule);
        jsonResult.put("TCNameInfo", TCNameInfo);
        jsonResult.put("lessonDateInfo", lessonDateInfo);
        jsonResult.put("TCStartDateInfo", TCStartDateInfo);
        jsonResult.put("TCEndDateInfo", TCEndDateInfo);
        return jsonResult.toJSONString();
    }

    public void addEmptyList(List<List<String>> courseSchedule, List<List<String>> TCNameInfo, List<List<String>> lessonDateInfo, List<List<String>> TCStartDateInfo, List<List<String>> TCEndDateInfo) {
        courseSchedule.add(Arrays.asList("", "", "", "", "", "", "", "", "", "", "", ""));
        TCNameInfo.add(Arrays.asList("", "", "", "", "", "", "", "", "", "", "", ""));
        lessonDateInfo.add(Arrays.asList("", "", "", "", "", "", "", "", "", "", "", ""));
        TCStartDateInfo.add(Arrays.asList("", "", "", "", "", "", "", "", "", "", "", ""));
        TCEndDateInfo.add(Arrays.asList("", "", "", "", "", "", "", "", "", "", "", ""));
    }

    // 根据节次安排课表
    public void switchLessonSection(List<List<String>> courseSchedule,
                                    List<List<String>> TCNameInfo,
                                    List<List<String>> lessonDateInfo,
                                    List<List<String>> TCStartDateInfo,
                                    List<List<String>> TCEndDateInfo,
                                    TeacherCourseScheduleBean teacherCourseScheduleBean) {
        int sectionNumber = -1;
        switch (teacherCourseScheduleBean.getLessonSection()) {
            case "第一节":
                sectionNumber = 0;
                break;
            case "第二节":
                sectionNumber = 1;
                break;
            case "第三节":
                sectionNumber = 2;
                break;
            case "第四节":
                sectionNumber = 3;
                break;
            case "第五节":
                sectionNumber = 4;
                break;
            case "第六节":
                sectionNumber = 5;
                break;
            case "第七节":
                sectionNumber = 6;
                break;
            case "第八节":
                sectionNumber = 7;
                break;
            case "第九节":
                sectionNumber = 8;
                break;
            case "第十节":
                sectionNumber = 9;
                break;
            case "第十一节":
                sectionNumber = 10;
                break;
            case "第十二节":
                sectionNumber = 11;
                break;
        }
        courseSchedule.get(courseSchedule.size() - 1).set(sectionNumber, teacherCourseScheduleBean.getCourseName().toString());
        TCNameInfo.get(TCNameInfo.size() - 1).set(sectionNumber, teacherCourseScheduleBean.getTeachClassName().toString());
        lessonDateInfo.get(lessonDateInfo.size() - 1).set(sectionNumber, teacherCourseScheduleBean.getLessonDate().toString());
        TCStartDateInfo.get(TCStartDateInfo.size() - 1).set(sectionNumber, teacherCourseScheduleBean.getTCStartDate().toString());
        TCEndDateInfo.get(TCEndDateInfo.size() - 1).set(sectionNumber, teacherCourseScheduleBean.getTCEndDate().toString());
    }

    // 获取当前date的星期（周一~周日）
    public static String getWeek(Date date) throws ParseException {
        SimpleDateFormat weekFormat = new SimpleDateFormat("E");
        return weekFormat.format(date);
    }

    // 获取当前日期学期的第一个星期一
    public static Date getFirstDay() throws ParseException {
        // 设定当前日期（数据库数据修改后再更改处理）
        String currStr = "2021-03-01";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currDate = dateFormat.parse(currStr);
        int currYear = currDate.getYear();
        int currMonth = currDate.getMonth();
        int newMonth;
        if (currMonth >= 8 || currMonth <= 1) {
            newMonth = 7;
        } else {
            newMonth = 1;
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR, currYear + 1900); //设置年
        gc.set(Calendar.MONTH, newMonth);       //这里0是1月..以此向后推
        gc.set(Calendar.DAY_OF_MONTH, 1);       //设置天
        Date newDate = gc.getTime();
        String week = getWeek(newDate);
        switch (week) {
            case "周一":
                break;
            case "周二":
                gc.add(Calendar.DAY_OF_YEAR, -1);
                break;
            case "周三":
                gc.add(Calendar.DAY_OF_YEAR, -2);
                break;
            case "周四":
                gc.add(Calendar.DAY_OF_YEAR, -3);
                break;
            case "周五":
                gc.add(Calendar.DAY_OF_YEAR, -4);
                break;
            case "周六":
                gc.add(Calendar.DAY_OF_YEAR, -5);
                break;
            case "周日":
                gc.add(Calendar.DAY_OF_YEAR, -6);
                break;
        }
        newDate = gc.getTime();
//        week = getWeek(newDate);
        String strDate = dateFormat.format(newDate);
        return dateFormat.parse(strDate);
    }

}
