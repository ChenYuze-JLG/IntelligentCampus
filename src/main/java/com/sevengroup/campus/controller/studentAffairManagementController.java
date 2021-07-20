package com.sevengroup.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class studentAffairManagementController {

    @RequestMapping("/studentAffairManagement")
    public String show(){
        return "studentAffairManagement";
    }
}
