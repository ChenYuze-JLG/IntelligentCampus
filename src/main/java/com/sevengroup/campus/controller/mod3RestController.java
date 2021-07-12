package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.BookBean;
import com.sevengroup.campus.bean.DmtManageBean;
import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.bean.layuiTableBean;
import com.sevengroup.campus.service.BookService;
import com.sevengroup.campus.service.DmtManageService;
import com.sevengroup.campus.service.MoneyService;
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
    @Autowired
    DmtManageService dmtManageService;
    @Autowired
    MoneyService moneyService;
    @Autowired
    BookService bookService;
    private String currentUser = "20194829"; // 当前用户名

    @GetMapping("/bookInfo")
    public List<BookBean> ALLBookInfo() {
        List<BookBean> list = new ArrayList<BookBean>();
        list = bookService.getAllBooks();
        for (BookBean bookBean:list) {
            System.out.println(bookBean);
        }
        return list;
    }
    @GetMapping("/selfBookList")
    /**
     * 处理获取借阅图书信息请求
     */
    public List<BookBean> dealRequestBookInfo() {
        List<BookBean> list = new ArrayList<BookBean>();
        list = bookService.getBorrowInfo(currentUser);
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
    public List<BookBean> testAjaxParam(@RequestParam(name = "name") String bookName) {

        List<BookBean> list = new ArrayList<BookBean>();
        list = bookService.findBookByName(bookName);
        for (BookBean bookBean:list) {
            System.out.println(bookBean);
        }
        return list;
    }

    @RequestMapping("/charge")
    public Boolean testBoolean() {
        return true;
    }

    @RequestMapping("/inOutRecord")
    public List<DmtManageBean> inOutInfo() {
        List<DmtManageBean> list = new ArrayList<DmtManageBean>();
        list = dmtManageService.getInOutRecords("id");
        return list;
    }
    @RequestMapping("/payRecord")
    public List<BookBean> payInfo() {
        List<BookBean> list = new ArrayList<BookBean>();
        list = bookService.getBorrowInfo(currentUser);
        for (BookBean bookBean:list) {
            System.out.println(bookBean);
        }
        return list;
    }
    @RequestMapping("/tableTest")
    public layuiTableBean tableTest() {
        layuiTableBean res = new layuiTableBean();
        res.setCode("0");
        res.setMsg("");
        List<BookBean> list = new ArrayList<BookBean>();
        list = bookService.getBorrowInfo(currentUser);
        res.setCount(list.size());
//        String data="[";
//        for (BookBean a:list) {
//            data += a.toString();
//        }
        res.setData(list.toString());
        return res;
    }
}
