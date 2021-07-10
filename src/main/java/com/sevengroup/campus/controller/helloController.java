package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {
    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }



    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String name, String password){
        UserBean userBean = userService.loginIn(name, password);
        if(userBean != null) {
            System.out.println(userBean.getName() + " " + userBean.getPassword());
            return "success";
        }
        else {
            return "login";
        }
    }

    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    public String modifyUser(String name, String password, @RequestParam(name = "modify") String action) {
        System.out.println("OK");
        return "login";
    }

}
