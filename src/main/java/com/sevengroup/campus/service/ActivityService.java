package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.ActivityBean;

import java.util.List;

public interface ActivityService {
    List<ActivityBean> listActivities();
    //name activityID organizer description rs re as ae imgUrl
    void saveActivity(String name, String activityID, String organizer, String description, String rs, String re, String as, String ae, String imgPath);
    void saveSignUp(String aID, String uID, String info);
}
