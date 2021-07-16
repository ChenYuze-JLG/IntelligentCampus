package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.BookBean;

import java.util.List;


/**
 * @Title: BookService
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/10/13:17
 */

public interface BookService {

    /**
     * 根据username 获取当前账号借阅信息
     * @param username 账号id
     * @return 返回借阅信息列表
     */
    List<BookBean> getBorrowInfo(String username);

    /**
     * 根据输入信息匹配图书馆书本信息
     * @param name 输入作者或书名
     * @return 返回匹配的信息列表
     */
    List<BookBean> findBookByName(String name);

    /**
     * 根据书本id获取书本信息
     * @param id 书本id
     * @return 返回书本信息
     */
    BookBean getBookByID(String id);

    /**
     * 根据书本id获取当前在馆书本信息
     * @param id 书本id
     * @return 返回改书本信息
     */
    BookBean getAvailableBookByID(String id);

    /**
     * 添加借阅信息
     * @param bookBean 所借阅的书本信息
     * @return 返回成功与失败  成功为true
     */
    boolean addBorrowRecord(BookBean bookBean);

    /**
     * 添加续借信息
     * @param bookBean 所续借的书本
     * @return 返回续借成功与否
     */
    boolean addBorrowAgainRecord(BookBean bookBean);

    /**
     *
     * @param bookID 图书id
     * @param userID 用户id
     * @return 返回借阅的图书信息
     */
    BookBean getBorrowedBookByID(String bookID, String userID);

    /**
     *
     * @return 返回所有图书列表
     */
    List<BookBean> getAllBooks();

    boolean confirmLendBook(String bookID, String userID, String fromUser);
}
