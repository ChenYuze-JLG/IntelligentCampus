package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.*;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.BookService;
import com.sevengroup.campus.service.DmtManageService;
import com.sevengroup.campus.service.MoneyService;
import com.sevengroup.campus.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/mod3")
public class mod3RestController {
    private Tool tool = new Tool();

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
        userBean.setNickname("name");
        return userBean;
    }

    @RequestMapping("/testAjaxList")
    public ArrayList<UserBean> testAjaxList() {
        ArrayList<UserBean> list = new ArrayList<UserBean>();
        UserBean userBean = new UserBean();
        userBean.setPassword("password");
        userBean.setNickname("nickname");
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

    /**
     *
    书籍列表
     */
    @RequestMapping("/bookTable")
    public bookTableBean tableTest(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                   @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                   @RequestParam(value = "field", defaultValue = "bookID") String sortField, // 当前选择排序的字段名称
                                   @RequestParam(value = "order", defaultValue = "asc") String sortOrder, // 当前对已选字段的排序方式
                                   @RequestParam(value = "bookName", defaultValue = "") String bookName
    ) throws JSONException {
        bookTableBean res = new bookTableBean();
        res.setCode("0");
        res.setMsg("");
        List<BookBean> list = new ArrayList<BookBean>();
        list = bookService.findBookByName(bookName);
        res.setCount(list.size());

        SortUtil.SortBookBean(list, sortField, sortOrder.equals("asc"));
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, list.size());
        List<BookBean> subList = list.subList(fromIndex, toIndex);
        res.setData(subList);
        return res;
    }

    /**
     *
     消费记录
     */
    @RequestMapping("/payRecordTable")
    public payRecordTableBean payRecordTableTest(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                    @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                    @RequestParam(value = "field", defaultValue = "UserID") String sortField, // 当前选择排序的字段名称
                                    @RequestParam(value = "order", defaultValue = "asc") String sortOrder, // 当前对已选字段的排序方式
                                             HttpServletRequest request
    ) throws JSONException {
        payRecordTableBean res = new payRecordTableBean();
        res.setCode("0");
        res.setMsg("");
        List<MoneyBean> list = new ArrayList<MoneyBean>();
        String userID = tool.getUserID(request);
        list = moneyService.getRecord(userID);
        SortUtil.SortMoneyBean(list, sortField, sortOrder.equals("asc"));
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, list.size());
        List<MoneyBean> subList = list.subList(fromIndex, toIndex);
        res.setCount(list.size());
        res.setData(subList);
        return res;
    }
    /**
     *
     归寝记录
     */
    @RequestMapping("/inOutRecordTable")
    public inOutRecordTableBean inOutRecordTableTest(@RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
                                    @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
                                    @RequestParam(value = "field", defaultValue = "inTime") String sortField, // 当前选择排序的字段名称
                                    @RequestParam(value = "order", defaultValue = "asc") String sortOrder, // 当前对已选字段的排序方式
                                             HttpServletRequest request
    ) throws JSONException {
        inOutRecordTableBean res = new inOutRecordTableBean();
        res.setCode("0");
        res.setMsg("");
        List<DmtManageBean> list = new ArrayList<DmtManageBean>();
        String userID = tool.getUserID(request);
        list = dmtManageService.getInOutRecords(userID);
        SortUtil.SortDmtManageBean(list, sortField, sortOrder.equals("asc"));
        // 计算传回的数据表格的页数和内容，并截取相应列表内容传回前端
        int fromIndex = (currPage - 1) * currPageSize;
        int toIndex = Math.min(currPage * currPageSize, list.size());
        List<DmtManageBean> subList = list.subList(fromIndex, toIndex);
        res.setCount(list.size());
        res.setData(subList);
        return res;
    }
}
