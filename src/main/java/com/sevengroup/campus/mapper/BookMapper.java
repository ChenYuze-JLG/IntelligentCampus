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

    List<BookBean> getBookInfo(String username);

    BookBean findBookByName(String name);


}
