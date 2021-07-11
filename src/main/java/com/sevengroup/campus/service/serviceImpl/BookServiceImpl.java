package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.BookBean;
import com.sevengroup.campus.mapper.BookMapper;
import com.sevengroup.campus.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: BookServiceImpl
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/10/13:16
 */

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<BookBean> getBorrowInfo(String username) {
        return bookMapper.getBorrowInfo(username);
    }

    @Override
    public List<BookBean> getFindBookList(String name) {
        String input = "%" + name + "%";
        return bookMapper.findBookByName(input);
    }

    @Override
    public BookBean getBookByID(String id) {
        return bookMapper.findBookByID(id);
    }

    @Override
    public BookBean getAvailableBookByID(String id) {
        return bookMapper.findAvailableBookByID(id);
 }

    @Override
    public int addBorrowRecord(BookBean bookBean) {
        return bookMapper.borrowBook(bookBean);
    }
}
