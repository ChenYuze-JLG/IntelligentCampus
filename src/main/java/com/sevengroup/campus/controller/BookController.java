package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.BookBean;
import com.sevengroup.campus.service.BookService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Title: BooksController
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/10/13:15
 */

@Controller
@RequestMapping("/library")
public class BookController {

    private String currentUser = "20194829"; // 当前用户名

    @Autowired
    BookService bookService;

    @GetMapping("/info")
    /**
     * 处理获取借阅图书信息请求
     */
    public List<BookBean> dealRequestBookInfo() {
//        bookService.getBookInfo(currentUser);
//        JSONObject json = new JSONObject();
        return   bookService.getBookInfo(currentUser);
    }

}
