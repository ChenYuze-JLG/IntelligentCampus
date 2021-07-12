package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ActivityBean;
import com.sevengroup.campus.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Controller
public class ActivityController {

    String imgPath;

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

    @ResponseBody
    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    Map<String, Object> addImg(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println("OK");

        String[] temp = file.getOriginalFilename().split("\\.");
        String imgType = temp[temp.length - 1];
        imgPath = "src\\main\\resources\\static\\activity\\";
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
        return new HashMap<String, Object>();
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
        return "activity";
    }

    @RequestMapping(value = "/launchEvent", method = RequestMethod.GET)
    String launchEvent() {
        return "launchEvent";
    }

}
