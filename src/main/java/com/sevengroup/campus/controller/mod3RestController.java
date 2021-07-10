package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/mod3")
public class mod3RestController {
    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/testAjax")
    public UserBean testAjax() {
        UserBean userBean = new UserBean();
        userBean.setPassword("password");
        userBean.setName("name");
        return userBean;
    }

    @RequestMapping("/testAjaxList")
    public ArrayList<UserBean> testAjaxList() {
        ArrayList<UserBean> list = new ArrayList<>();
        UserBean userBean = new UserBean();
        userBean.setPassword("password");
        userBean.setName("name");
        list.add(userBean);
        return list;
    }


}
