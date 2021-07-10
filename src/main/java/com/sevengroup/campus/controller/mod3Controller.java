package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mod3")
public class mod3Controller {
    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/car")
    public String showCar() {
        return "mod3/car";
    }
    @RequestMapping("/test")
    public String test() {
        return "mod3/index3";
    }
    @RequestMapping("/testAjax")
    public UserBean testAjax() {
        UserBean userBean = new UserBean();
        userBean.setPassword("password");
        userBean.setName("name");
        return userBean;
    }


}
