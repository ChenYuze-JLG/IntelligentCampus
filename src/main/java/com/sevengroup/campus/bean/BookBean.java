package com.sevengroup.campus.bean;


/**
 * @Title: Books
 * @Description: 图书信息
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/10/11:30
 */

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

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookYear() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getRenewCount() {
        return renewCount;
    }

    public void setRenewCount(String renewCount) {
        this.renewCount = renewCount;
    }

    public String getBorrowUserID() {
        return borrowUserID;
    }

    public void setBorrowUserID(String borrowUserID) {
        this.borrowUserID = borrowUserID;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "bookID='" + bookID + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookYear='" + bookYear + '\'' +
                ", bookType='" + bookType + '\'' +
                ", borrowTime='" + borrowTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                ", renewCount='" + renewCount + '\'' +
                ", borrowUserID='" + borrowUserID + '\'' +
                '}';
    }
}
