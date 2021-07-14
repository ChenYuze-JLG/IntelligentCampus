package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin("http://localhost:8080")
public class helloController {
    //将Service注入Web层
    @Autowired
    UserService userService;

//    @RequestMapping("/index")
//    public String show() {
//        return "teachAffair";
//    }

    @RequestMapping("head")
    public String head() {
        return "head";
    }

    @RequestMapping("login")
    public String hello() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam("name") String username,
                        @RequestParam("password") String password){
        UserBean userBean = userService.loginIn(username, password);
        System.out.println(username);
        System.out.println(password);
        if(userBean != null) {
            System.out.println(userBean.getUsername() + " " + userBean.getPassword());
            System.out.println(userBean.getRole());
            System.out.println(userBean.getRoomID());
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", userBean.getRole());
            return "redirect:index";
        }
        else {
            return "login";
        }
    }

    @Autowired
    HttpServletRequest request;
    @RequestMapping("/getSession")
    public void test() {
        String username = (String) request.getSession().getAttribute("username");
        System.out.println(username);
    }

    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    public String modifyUser(String name, String password, @RequestParam(name = "modify") String action) {
        System.out.println("OK");
        return "login";
    }
    @RequestMapping("/car")
    public String showCar() {
        return "mod3/car";
    }
    @RequestMapping("/test")
    public String mod3Test() {
        return "mod3/index3";
    }

}
