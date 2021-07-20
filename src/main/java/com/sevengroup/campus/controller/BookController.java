package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.BookBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.BookService;
import com.sevengroup.campus.service.MsgService;
import com.sevengroup.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
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

    private Tool tool = new Tool();

    @Autowired
    BookService bookService;

    @Autowired
    MsgService msgService;

    @Autowired
    UserService userService;


    @GetMapping("/info")
    /**
     * 处理获取借阅图书信息请求
     */
    public List<BookBean> dealRequestBorrowInfo(HttpServletRequest request) {
        String userID = tool.getUserID(request);

        return bookService.getBorrowInfo(userID);
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
    public boolean dealRequestBorrowBook(@RequestParam(value = "bookID") String bookID, HttpServletRequest request) {
        System.out.println("getID");
        String userID = tool.getUserID(request);
        System.out.println(userID);
        BookBean bookBean = bookService.getAvailableBookByID(bookID);
        System.out.println("before set");
        bookBean.setBorrowUser(userID);
        System.out.println("a set");

        return bookService.addBorrowRecord(bookBean);
    }

    @GetMapping("/borrowAgain")
    /**
     * 续借请求处理
     */
    public boolean dealRequestBorrowAgain(@RequestParam(value = "bookID") String bookID, HttpServletRequest request) {
        System.out.println("getID");
        String userID = tool.getUserID(request);
        System.out.println(userID);


        BookBean bookBean = bookService.getBorrowedBookByID(bookID, userID);

        System.out.println(bookBean);

        return bookService.addBorrowAgainRecord(bookBean);
    }

    @GetMapping("/lend")
    /**
     * 转借请求处理
     */
    public boolean dealRequestLendBook(@RequestParam(value = "bookID") String bookID,
                                       @RequestParam(value = "toUserID") String toUserID,
                                       HttpServletRequest request) {


        String userID = tool.getUserID(request);

        System.out.println(userID);
        System.out.println(toUserID);

        if (userService.checkUserID(toUserID) && !userID.equals(toUserID)) {
            msgService.saveMsg("GotLendBook", new Timestamp(System.currentTimeMillis()),
                    userID + " 向你转借了一本书： " + bookID + " ，点击查看", userID, toUserID, "http://localhost:8080/mod3/test?page=selfBookList");
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/gotLend")
    public boolean gotLend(HttpServletRequest request, @RequestParam(value = "bookID") String bookID,
                           @RequestParam(value = "fromUserID") String fromUserID) {
        String userID = tool.getUserID(request);

        boolean lendRes = bookService.confirmLendBook(bookID, userID, fromUserID);

        if (lendRes) {
            msgService.saveMsg("lenRes", new Timestamp(System.currentTimeMillis()),
                    userID + " 成功转借： " + bookID, userID, fromUserID, "");
        } else {
            msgService.saveMsg("lenRes", new Timestamp(System.currentTimeMillis()),
                    userID + " 转借该图书失败： " + bookID, userID, fromUserID, "");
        }

        return lendRes;
    }

}
