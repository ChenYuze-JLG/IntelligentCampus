package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.BookBean;
import com.sevengroup.campus.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public List<BookBean> dealRequestBorrowInfo(HttpServletRequest request, HttpServletResponse response) {

        /**
         * 自定义json格式
         *
         *
         * JSONObject json = new JSONObject();
         *         if (bookBeanList.size() != 0) {
         *             json.put("code", "100"); // 成功代码
         *         } else {
         *             json.put("code", "404"); //
         *         }
         *         json.put("msg", "传输查询当前借阅信息信息"); // 传输数据解释
         *
         *         // 具体数据内容
         *         for (BookBean bean : bookBeanList) {
         *             JSONObject childJSON = new JSONObject();
         *             childJSON.put("bookid", bean.getBookID());
         *             childJSON.put("bookname", bean.getBookName());
         *             childJSON.put("bookAuthor", bean.getBookAuthor());
         *             childJSON.put("bookDate", bean.getBookDate());
         *             childJSON.put("bookState", bean.getBookState());
         *             childJSON.put("bookType", bean.getBookType());
         *             childJSON.put("borrowTime", bean.getBorrowTime());
         *             childJSON.put("returnTime", bean.getReturnTime());
         *             childJSON.put("borrowCount", bean.getBorrowCount());
         *
         *             json.accumulate("data", childJSON);
         *         }
         *         response.setContentType("text/html;charset=UTF-8");
         *         response.getWriter().print(json);
         *
         */

        return bookService.getBorrowInfo(currentUser);
    }


    @GetMapping("/find")
    /**
     * 处理查询图书请求
     */
    public List<BookBean> dealRequestFindBook(HttpServletRequest request, HttpServletResponse response) {

        String getName = request.getParameter("name");

        return bookService.getFindBookList(getName);
    }


    @GetMapping("/order")
    /**
     * 预约借书请求处理
     */
    public boolean dealRequestBorrowBook(HttpServletRequest request, HttpServletResponse response) {

        String bookID = request.getParameter("bookID");
        String userID = request.getParameter("userID");

        BookBean bookBean = bookService.getAvailableBookByID(bookID);

        bookBean.setBorrowUser(userID);

        boolean addColomn = bookService.addBorrowRecord(bookBean);

        return addColomn;
    }

    @GetMapping("/borrowAgain")
    /**
     * 续借请求处理
     */
    public boolean dealRequestBorrowAgain(HttpServletRequest request, HttpServletResponse response) {

        String bookID = request.getParameter("bookID");
        String userID = request.getParameter("userID");

        BookBean bookBean = bookService.getBorrowedBookByID(bookID, userID);

        System.out.println(bookBean);

        boolean addColomn = bookService.addBorrowAgainRecord(bookBean);

        return addColomn;
    }

    @GetMapping("/lend")
    /**
     * 转借请求处理
     */
    public int dealRequestLendBook(HttpServletRequest request, HttpServletResponse response) {

        String bookID = request.getParameter("bookID");
        String userID = request.getParameter("userID");
        String toUserID = request.getParameter("toUserID");


        return 0;
    }

}
