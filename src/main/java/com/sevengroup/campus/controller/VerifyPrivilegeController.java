package com.sevengroup.campus.controller;

import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title: VerifyPrivilegeController
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/16/20:07
 */

@RestController
public class VerifyPrivilegeController {

    @Autowired
    PrivilegeService privilegeService;

    @Autowired
    Tool tool;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/hasRight")
    public boolean hasRight(@RequestParam(value = "right")String right) {
        String userID = tool.getUserID(request);

        return privilegeService.hasRight(userID, right);
    }

    @PostMapping("/addRight")
    public boolean addRight(@RequestParam(value = "right") String right) {
        String userID = tool.getUserID(request);

        return privilegeService.addRight(userID, right);
    }

    @PostMapping("/delRight")
    public boolean delRight(@RequestParam(value = "right") String right) {
        String userID = tool.getUserID(request);

        return privilegeService.delRight(userID, right);
    }

}
