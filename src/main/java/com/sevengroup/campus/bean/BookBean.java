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
@NoArgsConstructor
@AllArgsConstructor
public class BookBean {
    private String bookID; // 编号

    private String bookName; // 书名

    private String bookAuthor; // 书作者

    private String bookDate;  // 出版日期

    private String bookState; // 图示是否在馆

    private String bookType;  // 图书类型

    private String borrowTime;  // 借阅时间

    private String expirationTime; // 图书借阅到期时间

    private String returnTime;  // 还书时间

    private int borrowCount;  // 续借次数

    private String borrowUser;  // 借阅人

}
