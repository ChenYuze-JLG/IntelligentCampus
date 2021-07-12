package com.sevengroup.campus.service.impl;

import com.sevengroup.campus.bean.BookBean;
import com.sevengroup.campus.mapper.BookMapper;
import com.sevengroup.campus.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Title: BookServiceImpl
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/10/13:16
 */

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<BookBean> getBorrowInfo(String username) {
        return bookMapper.getBorrowInfo(username);
    }

    @Override
    public List<BookBean> findBookByName(String name) {
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
    @Transactional
    public boolean addBorrowRecord(BookBean bookBean) {
        int res = 0;
        try {
            res = bookMapper.borrowBook(bookBean);
        } catch (Exception e) {
            log.error("【error】:" + e);
            return false;
        }
        return res != 0;
    }

    @Override
    @Transactional
    public boolean addBorrowAgainRecord(BookBean bookBean) {
        int res = 0;
        final int MAX_COUNT = 3;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date currentDate = new Date();
            String date = sdf.format(currentDate);
            Date expirationTime = sdf.parse(bookBean.getExpirationTime());
            // 图书未超期且未超过续借次数限制
            if (bookBean.getBorrowCount() < MAX_COUNT && currentDate.before(expirationTime)) {
                bookBean.setBorrowCount(bookBean.getBorrowCount() + 1);
                bookBean.setReturnTime(date);
                System.out.println(bookBean.getReturnTime());
                res = bookMapper.borrowAgain(bookBean);
            } else {

                System.out.println("图书超期或超过续借次数限制");
            }
        } catch (Exception e) {
            log.error("【error】:" + e);
            return false;
        }
        return res != 0;
    }

    @Override
    public BookBean getBorrowedBookByID(String bookID, String userID) {
        return bookMapper.findBorrowedBookInfoByID(bookID, userID);
    }

    @Override
    public List<BookBean> getAllBooks() {
        return bookMapper.getAllBooksList();
    }
}
