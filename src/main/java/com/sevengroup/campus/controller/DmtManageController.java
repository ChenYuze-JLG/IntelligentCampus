package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.DmtManageBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.DmtManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Title: DmtManageController
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/21:14
 */

@RestController
@RequestMapping("dmt")
public class DmtManageController {

    @Autowired
    DmtManageService dmtManageService;

//    private String currentUser = "20156393"; // 学生
    private String currentUser = "20218862"; // 舍区管理员

    private Tool tool = new Tool();


    @GetMapping("/getRecord")
    public List<DmtManageBean> getInOutRecords(HttpServletRequest request) {
        // 8269
        String userID = tool.getUserID(request);

        return dmtManageService.getInOutRecords(userID);
    }


}
