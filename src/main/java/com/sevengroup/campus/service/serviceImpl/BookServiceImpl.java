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
    public List<BookBean> getBookInfo(String username) {
        return bookMapper.getBookInfo(username);
    }
}
