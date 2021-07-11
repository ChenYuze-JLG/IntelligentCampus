package com.sevengroup.campus.bean;

import lombok.Data;

import java.util.Date;

@Data
public class NewsBean {
    private int ID;
    private String url;
    private String publisher;
    private Date publishTime;
    private int views;
    private String title;
}
