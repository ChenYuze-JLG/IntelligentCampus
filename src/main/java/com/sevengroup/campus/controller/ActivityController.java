package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ActivityBean;
import com.sevengroup.campus.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@Controller
public class ActivityController {

    String imgPath;

    @Autowired
    ActivityService activityService;
    @Autowired
    HttpServletRequest request;

    @Configuration
    public class StateResourceConfigurer extends WebMvcConfigurerAdapter {
        /**
         * 配置访问静态资源
         * @param registry
         */
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry){
            registry.addResourceHandler("/static/**")
                    .addResourceLocations("file:E://Intelligence-campus/source/img/");
            super.addResourceHandlers(registry);
        }
    }

    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    String showActivities(Map<String, Object> map) {
        List<ActivityBean> activities = activityService.listActivities();
        map.put("activities", activities);
        for(ActivityBean activity : activities) {
            System.out.println(activity.getImgUrl());
        }
//        System.out.println("JHHHHHHHHH");
//        System.out.println(request.getSession().getAttribute("username"));
        return "activity";
    }

    @ResponseBody
    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    Map<String, Object> addImg(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println("OK");

        String[] temp = file.getOriginalFilename().split("\\.");
        String imgType = temp[temp.length - 1];
//        imgPath = "src\\main\\resources\\static\\activity";
        imgPath = "E://Intelligence-campus/source/img/";
        for(int i = 0; i < temp.length - 1; ++i)
            imgPath = imgPath + temp[i];

        File img = new File(imgPath + "." + imgType);
        while(img.exists()) {
            imgPath = imgPath + "1";
            img = new File(imgPath + "." + imgType);
        }
        img.createNewFile();

        System.out.println(img.getPath());
        InputStream ins = file.getInputStream();
        try {
            OutputStream os = new FileOutputStream(img);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        imgPath = imgPath + "." + imgType;

        System.out.println("start");
        System.out.println(imgPath);

        imgPath = imgPath.replace("E://Intelligence-campus/source/img", "../static/");
        imgPath = imgPath.replace("\\", "/");
        System.out.println(imgPath);
        System.out.println("end");
        return new HashMap<>();
    }

    @RequestMapping(value = "/saveActivity", method = RequestMethod.POST)
    String saveActivity(
            @RequestParam("name") String name,
            @RequestParam("interest") String type,
            @RequestParam("rs") String rs,
            @RequestParam("re") String re,
            @RequestParam("as") String as,
            @RequestParam("ae") String ae,
            @RequestParam("text") String description) {
        System.out.println(name);
        System.out.println(type);
        System.out.println(rs);
        System.out.println(re);
        System.out.println(as);
        System.out.println(ae);
        System.out.println(description);

        Random rand = new Random();
        int activityID = rand.nextInt(10000000);

        //name activityID organizer description rs re as ae imgUrl
        activityService.saveActivity(name, String.valueOf(activityID),
                (String) request.getSession().getAttribute("username"),
                description, rs, re, as, ae, imgPath);
        return "activity";
    }

    @RequestMapping(value = "/launchEvent", method = RequestMethod.GET)
    String launchEvent() {
        return "launchEvent";
    }

}
