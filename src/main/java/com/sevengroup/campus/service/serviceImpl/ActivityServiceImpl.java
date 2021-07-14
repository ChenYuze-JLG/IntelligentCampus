package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.ActivityBean;
import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.mapper.ActivityMapper;
import com.sevengroup.campus.mapper.UserMapper;
import com.sevengroup.campus.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    //将DAO注入Service层
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<ActivityBean> listActivities() {
        return activityMapper.listActivities();
    }

    @Override
    public String getOrganizer(String activityID) {
        return activityMapper.getOrganizer(activityID);
    }

    @Override
    public void saveActivity(String name, String activityID, String organizer, String description, String rs, String re, String as, String ae, String imgPath) {
        Timestamp timeRs = Timestamp.valueOf(rs);
        Timestamp timeRe = Timestamp.valueOf(re);
        Timestamp timeAs = Timestamp.valueOf(as);
        Timestamp timeAe = Timestamp.valueOf(ae);
        activityMapper.saveActivity(name, activityID, organizer, description, timeRs, timeRe, timeAs, timeAe, imgPath);
    }

    @Override
    public void saveSignUp(String aID, String uID, String info) {
        System.out.println("cyz cyz");
        activityMapper.saveSignUp(aID, uID, info);
    }
}
