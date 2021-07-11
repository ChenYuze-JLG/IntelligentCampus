package com.sevengroup.campus.bean;


import java.sql.Timestamp;
import java.util.Date;

public class ActivityBean {
    private int ID;
    private String activityID;
    private String name;
    private String organizer;
    private String description;
    private Timestamp publishTime;
    private Date registerStart;
    private Date registerEnd;
    private Date activityStart;
    private Date activityEnd;
    private String imgUrl;

    public String getImgUrl() {
        return "";
    }
}
