package com.sevengroup.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

    @RequestMapping("/messageInfo")
    String showMessageInfo() {

        return "messageInfo";
    }

}
