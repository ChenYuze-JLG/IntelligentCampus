package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.*;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.HeadService;
import com.sevengroup.campus.service.TeachAffairManageService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TeachAffairManageController {
    @Autowired
    TeachAffairManageService teachAffairManageService;

    @Autowired
    Tool tool;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HeadService headService;

//    private String teacherID = "20203035";
//    private String teacherID = "20178127";
    private String teacherID;

    // 获取登录用户ID
    public void getTeacherID() {
        teacherID = tool.getUserID(request);
        System.out.println("teacherID: " + teacherID);
    }

    // 教师教务管理主页面
    @RequestMapping("/teachAffairManagementForTeacher")
    public String showTeachAffairManagement(Map<String, Object> map) {
        headService.showHeadInfo(map);
        getTeacherID();
        return "teachAffairManagementForTeacher";
    }

    /*
        成绩管理部分——成绩查询
     */

    // 使用iframe插入的显示教师管理的所有教学班信息（点击显示教学班成绩表）
    @RequestMapping("/teachAffairManagementForTeacher/ScoreQuery")
    public String showViewScoreForTeacher() {
        return "TeachClassScoreQueryForTeacher";
    }

    // 教师查询教学班级信息JSON
    @RequestMapping(value = "/teachAffairManagementForTeacher/getTeachClassInfoJson")
    @ResponseBody
    public String getTeachClassInfoForTeacher(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                              @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                              @RequestParam(value = "field", defaultValue = "teachClassName") String sortField, // 当前选择排序的字段名称
                                              @RequestParam(value = "order", defaultValue = "asc") String sortOrder // 当前对已选字段的排序方式
//                                              @RequestParam(value = "teacherID") String teacherID
    ) throws JSONException {
        // 从用户登录信息中获取ID
        List<TeachClassInfoBean> teachClassInfo = teachAffairManageService.getTeachClassInfo(teacherID);
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", teachClassInfo.size());
        // 根据前端传回的排序参数对数据列表排序
        SortUtil.SortTeachClassInfoBean(teachClassInfo, sortField, sortOrder.equals("asc"));
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, teachClassInfo.size());
        List<TeachClassInfoBean> teachClassInfoBPerPage = teachClassInfo.subList(fromIndex, toIndex);
        jsonResult.put("data", teachClassInfoBPerPage);
        return jsonResult.toJSONString();
    }

    // layer层内iFrame内教师查询教学班成绩
    @RequestMapping("/teachAffairManagementForTeacher/ScoreQueryForTeacher")
    public String showScoreQueryForTeacher(@RequestParam(value = "teachClassID") String teachClassID) {
        return "ScoreQueryForTeacher";
    }

    // layer层内iFrame内教师查询教学班成绩图表
    @RequestMapping("/teachAffairManagementForTeacher/ScoreChartForTeacher")
    public String showScoreChartForTeacher(@RequestParam(value = "teachClassID") String teachClassID) {
        System.out.println(teachClassID);
        return "ScoreDistributionForTeacher";
    }

    // 获取教学班所有学生成绩信息JSON
    @RequestMapping("/teachAffairManagementForTeacher/getTeachClassScoreInfoJson")
    @ResponseBody
    public String getTeachClassScoreInfoJson(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                             @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                             @RequestParam(value = "field", defaultValue = "studentID") String sortField, // 当前选择排序的字段名称
                                             @RequestParam(value = "order", defaultValue = "asc") String sortOrder, // 当前对已选字段的排序方式
                                             @RequestParam(value = "teachClassID") String teachClassID
    ) throws JSONException {
        // 从用户登录信息中获取ID
        List<TeachClassScoreRecordBean> teachClassScoreRecord = teachAffairManageService.getTeachClassScoreRecord(teachClassID);
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", teachClassScoreRecord.size());
        // 根据前端传回的排序参数对数据列表排序
        SortUtil.SortTeachClassScoreRecordBean(teachClassScoreRecord, sortField, sortOrder.equals("asc"));
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, teachClassScoreRecord.size());
        List<TeachClassScoreRecordBean> teachClassScoreRecordBPerPage = teachClassScoreRecord.subList(fromIndex, toIndex);
        jsonResult.put("data", teachClassScoreRecordBPerPage);
        return jsonResult.toJSONString();
    }

    // 获取教学班所有学生成绩用于绘图，JSON格式
    @RequestMapping("/teachAffairManagementForTeacher/getTeachClassScoreChartDataJSON")
    @ResponseBody
    public String getTeachClassScoreChartDataJSON(@RequestParam(value = "teachClassID") String teachClassID) {
        // 从用户登录信息中获取ID
        List<TeachClassScoreRecordBean> teachClassScoreRecord = teachAffairManageService.getTeachClassScoreRecord(teachClassID);
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 1);
        jsonResult.put("msg", "");
        List<Integer> data = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
        for (TeachClassScoreRecordBean teachClassScoreRecordBean : teachClassScoreRecord) {
            Double score = teachClassScoreRecordBean.getCourseScore();
            if (score < 60) data.set(0, data.get(0) + 1);
            else {
                int index = (int) Math.ceil((score - 60) / 10);
                data.set(index, data.get(index) + 1);
            }
        }
        jsonResult.put("data", data);
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
        return jsonResult.toJSONString();
    }

    /*
        课程管理部分——课表查询、考勤记录查询、课程请假
     */
    // 使用iframe插入的显示课程安排页面
    @RequestMapping("/teachAffairManagementForTeacher/CourseScheduleQuery")
    public String showViewCourseSchedule() {
        return "CourseScheduleQueryForTeacher";
    }

    // 教师查询课表
    @RequestMapping(value = "/teachAffairManagementForTeacher/getCourseScheduleJSON", method = RequestMethod.POST)
    @ResponseBody
    public String getCourseScheduleForTeacher(
//            @RequestParam(value = "teacherID") String teacherID // 当前数据表格的页数
    ) throws ParseException {
        System.out.println(teacherID);
        List<TeacherCourseScheduleBean> teacherCourseSchedule = teachAffairManageService.getTeacherCourseSchedule(teacherID);
        System.out.println("size: " + teacherCourseSchedule.size());
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

    // 使用iframe插入的显示教学班级列表页面（点击显示考勤记录）
    @RequestMapping("/teachAffairManagementForTeacher/AbsenceRecordQuery")
    public String showViewAbsenceRecord() {
        return "TeachClassAbsenceQueryForTeacher";
    }

    // 获取教学班所有学生考勤信息JSON
    @RequestMapping("/teachAffairManagementForTeacher/getTeachClassAbsenceInfoJson")
    @ResponseBody
    public String getTeachClassAbsenceInfoJson(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                               @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                               @RequestParam(value = "field", defaultValue = "studentID") String sortField, // 当前选择排序的字段名称
                                               @RequestParam(value = "order", defaultValue = "asc") String sortOrder, // 当前对已选字段的排序方式
                                               @RequestParam(value = "teachClassID") String teachClassID
    ) throws JSONException {
        // 从用户登录信息中获取ID
        List<TeachClassAbsenceRecordBean> teachClassAbsenceRecord = teachAffairManageService.getTeachClassAbsenceRecord(teachClassID);
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", teachClassAbsenceRecord.size());
        // 根据前端传回的排序参数对数据列表排序
        SortUtil.SortTeachClassAbsenceRecordBean(teachClassAbsenceRecord, sortField, sortOrder.equals("asc"));
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, teachClassAbsenceRecord.size());
        List<TeachClassAbsenceRecordBean> teachClassScoreRecordPerPage = teachClassAbsenceRecord.subList(fromIndex, toIndex);
        jsonResult.put("data", teachClassScoreRecordPerPage);
        return jsonResult.toJSONString();
    }

    // layer层内iFrame内教师查询教学班考勤记录
    @RequestMapping("/teachAffairManagementForTeacher/AbsenceRecordQueryForTeacher")
    public String showAbsenceQueryForTeacher() {
        return "AbsenceRecordQueryForTeacher";
    }

    /*
        请假管理
     */

    // layer层教师审核请假
    @RequestMapping("/teachAffairManagementForTeacher/LeaveCheckForTeacher")
    public String showLeaveCheck() {
        return "LeaveCheckForTeacher";
    }

    // 获取学生假条数据（假条审核）
    @RequestMapping("/teachAffairManagementForTeacher/getTeachClassStudentLeaveInfoJSON")
    @ResponseBody
    public String getTeachClassStudentLeaveInfoJSON(@RequestParam(value = "studentID") String studentID,
                                                    @RequestParam(value = "lessonID") String lessonID) {
        // 从用户登录信息中获取ID
        List<TeachClassStudentLeaveInfoBean> teachClassStudentLeaveInfo = teachAffairManageService.getTeachClassStudentLeaveInfo(studentID, lessonID);
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 1);
        jsonResult.put("msg", "");
        jsonResult.put("count", teachClassStudentLeaveInfo.size());
        jsonResult.put("data", teachClassStudentLeaveInfo);
        return jsonResult.toJSONString();
    }

    // 设置学生请假状态
    @RequestMapping("/teachAffairManagementForTeacher/setStudentLeaveState")
    @ResponseBody
    public String setStudentLeaveState(@RequestParam(value = "studentID") String studentID,
                                       @RequestParam(value = "lessonID") String lessonID,
                                       @RequestParam(value = "state") String state) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("studentID", studentID);
        map.put("lessonID", lessonID);
        map.put("state", state);
        int res = teachAffairManageService.setStudentLeaveState(map);
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        if(res != -1) {
            jsonResult.put("code", 1);
        } else {
            jsonResult.put("code", 0);
        }
        jsonResult.put("msg", "");
        return jsonResult.toJSONString();
    }

    // 教学班请假记录查询
    @RequestMapping("/teachAffairManagementForTeacher/LeaveRecordQuery")
    public String showViewLeaveRecord() {
        return "TeachClassLeaveQueryForTeacher";
    }

    // 获取教学班所有学生请假信息JSON
    @RequestMapping("/teachAffairManagementForTeacher/getTeachClassLeaveInfoJSON")
    @ResponseBody
    public String getTeachClassLeaveInfoJson(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                             @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                             @RequestParam(value = "field", defaultValue = "state") String sortField, // 当前选择排序的字段名称
                                             @RequestParam(value = "order", defaultValue = "asc") String sortOrder, // 当前对已选字段的排序方式
                                             @RequestParam(value = "teachClassID") String teachClassID
    ) throws JSONException {
        // 从用户登录信息中获取ID
        List<TeachClassLeaveRecordBean> teachClassLeaveRecord = teachAffairManageService.getTeachClassLeaveRecord(teachClassID);
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", teachClassLeaveRecord.size());
        // 根据前端传回的排序参数对数据列表排序
        SortUtil.SortTeachClassLeaveRecordBean(teachClassLeaveRecord, sortField, sortOrder.equals("asc"));
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, teachClassLeaveRecord.size());
        List<TeachClassLeaveRecordBean> teachClassLeaveRecordPerPage = teachClassLeaveRecord.subList(fromIndex, toIndex);
        jsonResult.put("data", teachClassLeaveRecordPerPage);
        return jsonResult.toJSONString();
    }

    // layer层内iFrame内教师查询教学班请假记录
    @RequestMapping("/teachAffairManagementForTeacher/LeaveRecordQueryForTeacher")
    public String showLeaveQueryForTeacher() {
        return "LeaveRecordQueryForTeacher";
    }

    /*
        教室申请记录查询——申请表填写、申请记录查询
     */

    // 使用iframe插入的教室申请表页面
    @RequestMapping("/teachAffairManagement/ApplicationFormFill")
    public String showApplicationForm() {
//        return "CRApplicationFormFill";
        return "studentApplicationClassroom";
    }

    // 使用iframe插入的教室申请记录安排页面
    @RequestMapping("/teachAffairManagement/ApplicationRecordQuery")
    public String showApplicationRecord() {
        return "CRApplicationRecordQuery";
    }

    // 教室申请记录查询getCRApplicationRecord
    @RequestMapping(value = "/teachAffairManagement/getCRApplicationRecordJSON")
    @ResponseBody
    public String getClassroomRecordJSON(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                         @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                         @RequestParam(value = "field", defaultValue = "classroomID") String sortField, // 当前选择排序的字段名称
                                         @RequestParam(value = "order", defaultValue = "asc") String sortOrder // 当前对已选字段的排序方式
//                                         @RequestParam(value = "username") String username
    ) throws JSONException {
        // 从用户登录信息中获取ID
        List<CRApplicationRecordBean> CRApplicationRecord = teachAffairManageService.getCRApplicationRecord(teacherID);
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", CRApplicationRecord.size());
        // 根据前端传回的排序参数对数据列表排序
        SortUtil.SortCRApplicationRecordBean(CRApplicationRecord, sortField, sortOrder.equals("asc"));
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, CRApplicationRecord.size());
        List<CRApplicationRecordBean> CRApplicationRecordPerPage = CRApplicationRecord.subList(fromIndex, toIndex);
        jsonResult.put("data", CRApplicationRecordPerPage);
        return jsonResult.toJSONString();
    }
}
