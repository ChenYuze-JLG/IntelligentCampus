package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: Books
 * @Description: 图书信息
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/10/11:30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
    private String bookID; // 编号

    private String bookName; // 书名

    private String bookAuthor; // 书作者

    private String bookYear;  // 出版年份

    private String bookType;  // 图书类型

    private String borrowTime;  // 借阅时间

    private String returnTime;  // 还书时间

    private String renewCount;  // 续借次数

    private String borrowUserID; // 借阅人

}
