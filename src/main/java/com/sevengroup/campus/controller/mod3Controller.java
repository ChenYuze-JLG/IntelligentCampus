package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ActivityBean;
import com.sevengroup.campus.bean.NewsBean;
import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin("http://localhost:8080")
@RequestMapping("/mod3")
public class mod3Controller {
    //将Service注入Web层
    @Autowired
    UserService userService;
    @Autowired
    ActivityService activityService;
    @Autowired
    NewsService newsService;
    @Autowired
    MsgService msgService;
    @Autowired
    HeadService headService;
    @Autowired
    HttpServletRequest request;

    private List<ActivityBean> activities;
    private List<NewsBean> news;

    @RequestMapping("/car")
    public String showCar() {
        return "mod3/car";
    }
    @RequestMapping("/nav")
    public String showNav() {
        return "mod3/Nav3";
    }
    @RequestMapping("/test")
    public String test(Map<String, Object> map) {

        activities = activityService.listActivities();
        map.put("activities", activities);
        news = newsService.listNews();
        map.put("news", news);
        headService.showHeadInfo(map);
        for(ActivityBean activity : activities) {
            System.out.println(activity.getImgUrl());
        }
        for(NewsBean _new : news) {
            System.out.println(_new.getTitle());
        }
        return "mod3/index3";
    }


}
