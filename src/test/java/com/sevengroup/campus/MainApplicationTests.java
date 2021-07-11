package com.sevengroup.campus;

import com.sevengroup.campus.bean.ActivityBean;
import com.sevengroup.campus.service.ActivityService;
import com.sevengroup.campus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MainApplicationTests {

    @Autowired
    UserService userService;
    ActivityService activityService;

    @Test
    public void contextLoads() {
//        UserBean userBean = userService.loginIn("1","1");
//        System.out.println("该用户ID为：");
//        System.out.println(userBean.getName());
        System.out.println("OK");
        List<ActivityBean> activities = activityService.listActivities();
        for(ActivityBean activity : activities) {
            System.out.println(activity.getImgUrl());
        }
    }

}
