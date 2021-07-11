package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.ActivityBean;
import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.mapper.ActivityMapper;
import com.sevengroup.campus.mapper.UserMapper;
import com.sevengroup.campus.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
