package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.ActivityBean;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ActivityMapper {
    List<ActivityBean> listActivities();
    void saveActivity(String name, String activityID, String organizer, String description, Timestamp timeRs, Timestamp timeRe, Timestamp timeAs, Timestamp timeAe, String imgPath);
    void saveSignUp(String aID, String uID, String info);
}
