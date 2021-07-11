package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.ScoreRecordBean;
import com.sevengroup.campus.service.ScoreRecordService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScoreRecordController {
    @Autowired
    ScoreRecordService scoreRecordService;

    @RequestMapping("/ScoreRecord")
    public String show() {
        return "teachAffair";
    }

    @RequestMapping(value = "/ScoreRecord/getStudentScore")
    @ResponseBody
    public String getStudentScore(Model model) throws JSONException {
        List<ScoreRecordBean> scoresInfo = scoreRecordService.getStudentAll("20159546");
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", scoresInfo.size());
        result.put("data", scoresInfo);
//        System.out.println(result.toString());
//        model.addAttribute("code",0);
//        model.addAttribute("msg", "");
//        model.addAttribute("count", scoresInfo.size());
//        System.out.println(JSONObject.toJSONString(scoresInfo));
//        model.addAttribute("data", JSONObject.toJSONString(scoresInfo));
        return result.toJSONString();
    }
}
