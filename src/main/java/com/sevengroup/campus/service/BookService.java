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

    List<BookBean> getBookInfo(String username);
}
