package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ActivityBean;
import com.sevengroup.campus.bean.NewsBean;
import com.sevengroup.campus.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    String showActivities(Map<String, Object> map) {
        List<ActivityBean> activities = activityService.listActivities();
        map.put("activities", activities);
        for(ActivityBean activity : activities) {
            System.out.println(activity.getImgUrl());
        }
        return "activity";
    }
}
