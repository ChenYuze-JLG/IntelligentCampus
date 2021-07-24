package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.StudentApplicationRecordBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.StudentApplicationRecordService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class StudentApplicationRecordController {
    //将Service注入Web层
    @Autowired
    private StudentApplicationRecordService studentApplicationRecordService;

    @RequestMapping("/studentApplicationRecord")
    public String show(){
        return "StudentApplicationClassroomRecord";
    }

    @RequestMapping("/studentApplicationRecord/queryStudentApplicationRecord")
    @ResponseBody
    public String query(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                      @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                      @RequestParam(value = "date") String date,
                      HttpServletRequest request
    ) throws JSONException {
        //调取系统用户的username即为studentID
        String studentID = new Tool().getUserID(request);
//        System.out.println("username" + studentID);
        //
        List<StudentApplicationRecordBean> studentApplicationRecordBeans = studentApplicationRecordService.queryStudentApplicationRecord(studentID, date);
        Collections.sort(studentApplicationRecordBeans, Comparator.comparing(StudentApplicationRecordBean::getDate).reversed());
//        for (int i = 0; i < studentApplicationRecordBeans.size(); i++){
//            System.out.println(studentApplicationRecordBeans.get(i).toString());
//        }

        //向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code",0);
        jsonResult.put("msg", "");
        jsonResult.put("count",studentApplicationRecordBeans.size());

        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, studentApplicationRecordBeans.size());
        List<StudentApplicationRecordBean> applicationRecordPerPage = studentApplicationRecordBeans.subList(fromIndex, toIndex);
        jsonResult.put("data", applicationRecordPerPage);
        return jsonResult.toJSONString();
    }
}
