package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.ScoreRecordBean;
import com.sevengroup.campus.bean.SortUtil;
import com.sevengroup.campus.service.ScoreRecordService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScoreRecordController {
    @Autowired
    ScoreRecordService scoreRecordService;

    // 主页面
    @RequestMapping("/teachAffairManagement")
    public String showTeachAffairManagement() {
        return "teachAffairManagement";
    }

    /*
        成绩管理部分——成绩查询
     */

    // 使用iframe插入的显示成绩页面
    @RequestMapping("/teachAffairManagement/ViewScore")
    public String showViewScore() {
        return "ViewScore";
    }

    // 学生查询成绩
    @RequestMapping(value = "/teachAffairManagement/ScoreRecord/getScoreForStudent")
    @ResponseBody
    public String getScoreForStudent(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                     @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                     @RequestParam(value = "field", defaultValue = "credit") String sortField, // 当前选择排序的字段名称
                                     @RequestParam(value = "order", defaultValue = "desc") String sortOrder // 当前对已选字段的排序方式
    ) throws JSONException {
        // 从用户登录信息中获取ID
        List<ScoreRecordBean> scoresInfo = scoreRecordService.getStudentAll("20159546");
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", scoresInfo.size());
        // 根据前端传回的排序参数对数据列表排序
        SortUtil.anyProperSort(scoresInfo, sortField, sortOrder.equals("asc"));
//        for (int i = 0; i < scoresInfo.size(); i++) {
//            System.out.println(scoresInfo.get(i).toString());
//        }
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, scoresInfo.size());
        List<ScoreRecordBean> scoresInfoPerPage = scoresInfo.subList(fromIndex, toIndex);
        jsonResult.put("data", scoresInfoPerPage);
//        System.out.println(currPage + " " + currPageSize);
//        System.out.println(sortField + " " + sortOrder);
        return jsonResult.toJSONString();
    }

    // 教师查询成绩
    @RequestMapping(value = "/teachAffairManagement/ScoreRecord/getScoreForTeacher")
    @ResponseBody
    public String getScoreForTeacher(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                     @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                     @RequestParam(value = "field", defaultValue = "credit") String sortField, // 当前选择排序的字段名称
                                     @RequestParam(value = "order", defaultValue = "desc") String sortOrder // 当前对已选字段的排序方式
    ) throws JSONException {
        // 从用户登录信息中获取ID
        List<ScoreRecordBean> scoresInfo = scoreRecordService.getStudentAll("20159546");
        // 向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", 0);
        jsonResult.put("msg", "");
        jsonResult.put("count", scoresInfo.size());
        // 根据前端传回的排序参数对数据列表排序
        SortUtil.anyProperSort(scoresInfo, sortField, sortOrder.equals("asc"));
//        for (int i = 0; i < scoresInfo.size(); i++) {
//            System.out.println(scoresInfo.get(i).toString());
//        }
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, scoresInfo.size());
        List<ScoreRecordBean> scoresInfoPerPage = scoresInfo.subList(fromIndex, toIndex);
        jsonResult.put("data", scoresInfoPerPage);
//        System.out.println(currPage + " " + currPageSize);
//        System.out.println(sortField + " " + sortOrder);
        return jsonResult.toJSONString();
    }

    /*
        课程管理部分——课表查询、考勤记录查询、课程请假
     */

    // 学生查询课表
    @RequestMapping(value = "/teachAffairManagement/CourseManagement/getCourseScheduleForStudent")
    @ResponseBody
    public String getCourseScheduleForStudent(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
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

    // 教师查询课表
    @RequestMapping(value = "/teachAffairManagement/CourseManagement/getCourseScheduleForTeacher")
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

    // 学生查询考勤记录
    @RequestMapping(value = "/teachAffairManagement/CourseManagement/getAbsenceRecordForStudent")
    @ResponseBody
    public String getAbsenceRecordForStudent(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
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

    // 教师查询考勤记录
    @RequestMapping(value = "/teachAffairManagement/CourseManagement/getAbsenceRecordForTeacher")
    @ResponseBody
    public String getAbsenceRecordForTeacher(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
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

    // 学生请假申请

    // 辅导员批准请假

    /*
        教室申请记录查询——申请表填写、申请记录查询
     */

    // 教室申请记录查询
    @RequestMapping(value = "/teachAffairManagement/ClassroomManagement/getClassroomRecord")
    @ResponseBody
    public String getClassroomRecord(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
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
}
