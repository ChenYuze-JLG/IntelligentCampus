package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("http://localhost:8080")
@RequestMapping("/mod3")
public class mod3Controller {
    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/car")
    public String showCar() {
        return "mod3/car";
    }
    @RequestMapping("/nav")
    public String showNav() {
        return "mod3/Nav3";
    }
    @RequestMapping("/test")
    public String test() {
        return "mod3/index3";
    }


}
