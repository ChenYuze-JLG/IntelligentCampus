package com.sevengroup.campus.controller;

import com.sevengroup.campus.service.ScoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScoreRecordController {
    @Autowired
    ScoreRecordService scoreRecordService;

    @RequestMapping("/ScoreRecord")
    public String show() {
        return "teachAffair";
    }

//    @RequestMapping("/ScoreRecord/getStudentScore")
//    public
}
