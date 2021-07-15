package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.MsgBean;
import com.sevengroup.campus.service.ActivityService;
import com.sevengroup.campus.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MsgController {

    @Autowired
    MsgService msgService;
    @Autowired
    ActivityService activityService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/messageInfo")
    String showMessageInfo(Map<String, Object> map) {
        String username = (String) request.getSession().getAttribute("username");
        map.put("msgs", msgService.listMsgs(username));
        return "messageInfo";
    }

    @RequestMapping("/messageInfo1")
    String showMessageInfo1(Map<String, Object> map) {
        String username = (String) request.getSession().getAttribute("username");
        map.put("msgs", msgService.allMsgs(username));
        return "messageInfo";
    }

    @RequestMapping("/verify")
    String verify() {
        return "verify";
    }

    @ResponseBody
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    Map<String, Object> check(@RequestParam Map<String, Object> x) {
//        int id = Integer.parseInt((String) x.get("id"));
        String id = (String) x.get("id");
        System.out.println(id);
        String username = (String) request.getSession().getAttribute("username");
        msgService.setHandled(id);
//        void saveMsg(String type, Timestamp time, String info, String sender,
//                String receiver, String url);
        System.out.println("trans: ");
        System.out.println((String) x.get("info"));
        System.out.println((String) x.get("receiver"));
        msgService.saveMsg("admission",
                new Timestamp(System.currentTimeMillis()),
                (String) x.get("info"),
                username,
                (String) x.get("receiver"),
                "");
        return new HashMap<>();
    }

}
