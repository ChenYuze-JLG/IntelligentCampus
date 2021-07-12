package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.BookBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @Title: BookMapper
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/10/13:18
 */


@Mapper
@Component
public interface BookMapper {

    List<BookBean> getBorrowInfo(String username);

    List<BookBean> findBookByName(String name);

    BookBean findBookByID(String id);

    BookBean findAvailableBookByID(String id);

    int borrowBook(BookBean bookBean);

    int borrowAgain(BookBean bookBean);

    BookBean findBorrowedBookInfoByID(String bookID, String userID);

    List<BookBean> getAllBooksList();
}
