package com.sevengroup.campus.controller;

import com.sevengroup.campus.service.impl.MoneyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: MoneyController
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/18:53
 */

@RestController
public class MoneyController {

    @Autowired
    private MoneyServiceImpl moneyService;


    @GetMapping("/addCredit")
    // 充值
    public boolean dealRequestAddCredit(HttpServletRequest request, HttpServletResponse response) {
        String transactionType = request.getParameter("type");
        String userID = request.getParameter("id");
        double money = Double.parseDouble(request.getParameter("money"));

        boolean num = moneyService.addCredit(transactionType, userID, money);

        return num;
    }


}
