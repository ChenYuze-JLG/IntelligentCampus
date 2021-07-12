package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.DmtManageBean;
import com.sevengroup.campus.service.DmtManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    @GetMapping("/getRecord")
    public List<DmtManageBean> getInOutRecords(HttpServletRequest request, HttpServletResponse response) {

        String dormitoryID = request.getParameter("dormitoryID");

        return dmtManageService.getInOutRecords(dormitoryID);
    }


}
