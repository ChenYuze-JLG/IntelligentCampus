package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.AppBean;
import com.sevengroup.campus.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    AppService appService;

    @RequestMapping("/getApps")
    List<AppBean> getApps() {
        return appService.listApps();
    }

}
