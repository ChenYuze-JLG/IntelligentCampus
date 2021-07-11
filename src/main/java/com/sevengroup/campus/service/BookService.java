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

    List<BookBean> getBorrowInfo(String username);

    List<BookBean> getFindBookList(String name);

    BookBean getBookByID(String id);

    BookBean getAvailableBookByID(String id);

    int addBorrowRecord(BookBean bookBean);
}
