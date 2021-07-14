package com.sevengroup.campus.controller;

import com.sevengroup.campus.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MsgController {

    @Autowired
    MsgService msgService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/messageInfo")
    String showMessageInfo(Map<String, Object> map) {
        String username = (String) request.getSession().getAttribute("username");
        map.put("msgs", msgService.listMsgs(username));
        return "messageInfo";
    }

}
