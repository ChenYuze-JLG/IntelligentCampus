package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.BookBean;
import com.sevengroup.campus.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: BooksController
 * @Description: 处理图书相关信息请求
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/10/13:15
 */

@RestController
@RequestMapping("/library")
public class BookController {

    private String currentUser = "20194829"; // 当前用户名
    private String name = "这样"; // 查找bookname

    @Autowired
    BookService bookService;


    @GetMapping("/info")
    /**
     * 处理获取借阅图书信息请求
     */
    public List<BookBean> dealRequestBorrowInfo() {

        return bookService.getBorrowInfo(currentUser);
    }


    @GetMapping("/find")
    /**
     * 处理查询图书请求
     */
    public List<BookBean> dealRequestFindBook(@RequestParam(value = "name") String getName) {

        return bookService.findBookByName(getName);
    }

    @GetMapping("/all")
    // 返回所有图书列表
    public List<BookBean> dealRequestGetBooksList() {

        return bookService.getAllBooks();
    }


    @GetMapping("/order")
    /**
     * 预约借书请求处理
     */
    public boolean dealRequestBorrowBook(@RequestParam(value = "bookID") String bookID) {

        BookBean bookBean = bookService.getAvailableBookByID(bookID);

        bookBean.setBorrowUser(currentUser);

        return bookService.addBorrowRecord(bookBean);
    }

    @GetMapping("/borrowAgain")
    /**
     * 续借请求处理
     */
    public boolean dealRequestBorrowAgain(@RequestParam(value = "bookID") String bookID) {

        BookBean bookBean = bookService.getBorrowedBookByID(bookID, currentUser);

        System.out.println(bookBean);

        return bookService.addBorrowAgainRecord(bookBean);
    }

    @GetMapping("/lend")
    /**
     * 转借请求处理
     */
    public int dealRequestLendBook(@RequestParam(value = "bookID") String bookID,
                                   @RequestParam(value = "userID") String userID,
                                   @RequestParam(value = "toUserID") String toUserID) {


        return 0;
    }

}
