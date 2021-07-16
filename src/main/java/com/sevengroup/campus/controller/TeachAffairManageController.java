package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.*;
import com.sevengroup.campus.service.TeachAffairManageService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeachAffairManageController {
    @Autowired
    TeachAffairManageService teachAffairManageService;

    // 教师教务管理主页面
    @RequestMapping("/teachAffairManagementForTeacher")
    public String showTeachAffairManagement() {
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
                                     @RequestParam(value = "order", defaultValue = "asc") String sortOrder, // 当前对已选字段的排序方式
                                     @RequestParam(value = "teacherID") String teacherID
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

    /*
        课程管理部分——课表查询、考勤记录查询、课程请假
     */
    // 使用iframe插入的显示课程安排页面
    @RequestMapping("/teachAffairManagementForTeacher/LessonScheduleQuery")
    public String showViewLessonSchedule() {
        return "LessonScheduleQueryForTeacher";
    }

    // 教师查询课表
    @RequestMapping(value = "/teachAffairManagementForTeacher/getCourseSchedule")
    @ResponseBody
    public String getCourseScheduleForTeacher(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                              @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                              @RequestParam(value = "field", defaultValue = "credit") String sortField, // 当前选择排序的字段名称
                                              @RequestParam(value = "order", defaultValue = "desc") String sortOrder // 当前对已选字段的排序方式
    ) throws JSONException {
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", 0);
        jsonResult.put("data", "");
        return jsonResult.toJSONString();
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


    // 教师批准请假
    @RequestMapping("/teachAffairManagementForTeacher/CourseLeaveCheck")
    public String showCourseLeaveCheck() {
        return "CourseLeaveCheckForTeacher";
    }

    /*
        教室申请记录查询——申请表填写、申请记录查询
     */

    // 使用iframe插入的教室申请表页面
    @RequestMapping("/teachAffairManagement/ApplicationFormFill")
    public String showApplicationForm() {
        return "CRApplicationFormFill";
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
                                         @RequestParam(value = "order", defaultValue = "asc") String sortOrder, // 当前对已选字段的排序方式
                                         @RequestParam(value = "username") String username
    ) throws JSONException {
        // 从用户登录信息中获取ID
        List<CRApplicationRecordBean> CRApplicationRecord = teachAffairManageService.getCRApplicationRecord(username);
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
