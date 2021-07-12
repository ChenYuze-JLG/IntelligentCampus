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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Date getRegisterStart() {
        return registerStart;
    }

    public void setRegisterStart(Date registerStart) {
        this.registerStart = registerStart;
    }

    public Date getRegisterEnd() {
        return registerEnd;
    }

    public void setRegisterEnd(Date registerEnd) {
        this.registerEnd = registerEnd;
    }

    public Date getActivityStart() {
        return activityStart;
    }

    public void setActivityStart(Date activityStart) {
        this.activityStart = activityStart;
    }

    public Date getActivityEnd() {
        return activityEnd;
    }

    public void setActivityEnd(Date activityEnd) {
        this.activityEnd = activityEnd;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "ActivityBean{" +
                "ID=" + ID +
                ", activityID='" + activityID + '\'' +
                ", name='" + name + '\'' +
                ", organizer='" + organizer + '\'' +
                ", description='" + description + '\'' +
                ", publishTime=" + publishTime +
                ", registerStart=" + registerStart +
                ", registerEnd=" + registerEnd +
                ", activityStart=" + activityStart +
                ", activityEnd=" + activityEnd +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
