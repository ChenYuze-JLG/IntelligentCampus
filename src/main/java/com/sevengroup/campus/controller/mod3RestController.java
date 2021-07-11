package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.BookBean;
import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.service.BookService;
import com.sevengroup.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/mod3")
public class mod3RestController {
    //将Service注入Web层
    @Autowired
    UserService userService;
    private String currentUser = "20194829"; // 当前用户名

    @Autowired
    BookService bookService;

    @GetMapping("/bookInfo")
    /**
     * 处理获取借阅图书信息请求
     */
    public List<BookBean> dealRequestBookInfo() {
        List<BookBean> list = new ArrayList<BookBean>();
        list = bookService.getBookInfo(currentUser);
        for (BookBean bookBean:list) {
            System.out.println(bookBean);
        }
        return list;
    }
    @RequestMapping("/testAjax")
    public UserBean testAjax() {
        UserBean userBean = new UserBean();
        userBean.setPassword("password");
        userBean.setName("name");
        return userBean;
    }

    @RequestMapping("/testAjaxList")
    public ArrayList<UserBean> testAjaxList() {
        ArrayList<UserBean> list = new ArrayList<UserBean>();
        UserBean userBean = new UserBean();
        userBean.setPassword("password");
        userBean.setName("name");
        list.add(userBean);
        return list;
    }

    @RequestMapping("/selectBookByName")
    public ArrayList<UserBean> testAjaxParam(@RequestParam(name = "name") String name) {

        ArrayList<UserBean> list = new ArrayList<UserBean>();
        UserBean userBean = new UserBean();
        userBean.setPassword("password");
        userBean.setName(name);
        list.add(userBean);
        return list;
    }


}
