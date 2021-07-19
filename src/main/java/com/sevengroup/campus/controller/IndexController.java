package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ActivityBean;
import com.sevengroup.campus.bean.MsgBean;
import com.sevengroup.campus.bean.NewsBean;
import com.sevengroup.campus.service.ActivityService;
import com.sevengroup.campus.service.HeadService;
import com.sevengroup.campus.service.MsgService;
import com.sevengroup.campus.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
public class IndexController {
    //将Service注入Web层
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

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        if(request.getSession().getAttribute("username") == null) {
            request.getSession().setAttribute("username", "");
        }
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
        return "index";
    }

    @RequestMapping(value = "/message")
    public String showMessages(Map<String, Object> map) {
        headService.showHeadInfo(map);
        return "message";
    }

    @RequestMapping(value = "/logout")
    public String logout(Map<String, Object> map) {
        activities = activityService.listActivities();
        map.put("activities", activities);
        news = newsService.listNews();
        map.put("news", news);

        request.getSession().setAttribute("username", "");
        request.getSession().setAttribute("role", "游客");

        headService.showHeadInfo(map);

        return "index";
    }

}
