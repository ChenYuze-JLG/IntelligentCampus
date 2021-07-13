package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ActivityBean;
import com.sevengroup.campus.bean.NewsBean;
import com.sevengroup.campus.service.ActivityService;
import com.sevengroup.campus.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@Controller
public class IndexController {
    //将Service注入Web层
    @Autowired
    ActivityService activityService;
    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        List<ActivityBean> activities = activityService.listActivities();
        map.put("activities", activities);
        List<NewsBean> news = newsService.listNews();
        map.put("news", news);
        for(ActivityBean activity : activities) {
            System.out.println(activity.getImgUrl());
        }
        for(NewsBean _new : news) {
            System.out.println(_new.getTitle());
        }
//        map.put("x", 12);
        return "index";
    }

    @RequestMapping(value = "/message")
    public String showMessages() {
        return "message";
    }

}
