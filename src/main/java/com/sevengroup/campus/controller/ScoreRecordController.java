package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ScoreRecordBean;
import com.sevengroup.campus.service.ScoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreRecordController {
    @Autowired
    ScoreRecordService scoreRecordService;

    @RequestMapping("/ScoreRecord")
    public String show() {
        return "teachAffair";
    }

    @RequestMapping(value = "/ScoreRecord/getStudentScore")
    @ResponseBody
    public List<ScoreRecordBean> getStudentScore(Model model) {
        List<ScoreRecordBean> scoresInfo = scoreRecordService.getStudentAll("20159546");
        return scoresInfo;
    }
}
