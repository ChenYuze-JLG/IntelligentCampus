package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.AbsenceRecordForStudentBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.AbsenceRecordQueryForStudentService;
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
public class AbsenceRecordQueryForStudentController {

    //将Service注入Web层
    @Autowired
    private AbsenceRecordQueryForStudentService absenceRecordQueryForStudentService;

    @RequestMapping("/absenceRecordQueryForStudent")
    public String show(){
        return "absenceRecordQueryForStudent";
    }

    @RequestMapping(value = "/absenceRecordQuery")
    @ResponseBody
    public String query(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                        @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                        @RequestParam(value = "date") String date,
                        HttpServletRequest request
    ) throws JSONException {
        //调取系统用户的username即为studentID
        String studentID = new Tool().getUserID(request);
//        System.out.println("username" + studentID);
        List<AbsenceRecordForStudentBean> absenceRecordForStudentBeanList = absenceRecordQueryForStudentService.queryAbsenceForStudent(studentID, date);
        Collections.sort(absenceRecordForStudentBeanList, Comparator.comparing(AbsenceRecordForStudentBean::getAbsenceDate).reversed());//对list按照时间降序排序
        //向前端传回格式为json
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code",0);
        jsonResult.put("msg", "");
        jsonResult.put("count",absenceRecordForStudentBeanList.size());
//        for (int i = 0; i < absenceRecordForStudentBeanList.size(); i++){
//            System.out.println(absenceRecordForStudentBeanList.get(i).toString());
//        }
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, absenceRecordForStudentBeanList.size());
        List<AbsenceRecordForStudentBean> absenceRecordPerPage = absenceRecordForStudentBeanList.subList(fromIndex, toIndex);
        jsonResult.put("data", absenceRecordPerPage);
        return jsonResult.toJSONString();
    }
}
