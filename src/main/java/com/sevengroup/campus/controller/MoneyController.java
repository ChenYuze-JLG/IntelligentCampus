package com.sevengroup.campus.controller;

import com.sevengroup.campus.service.MoneyService;
import com.sevengroup.campus.service.impl.MoneyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private MoneyService moneyService;


    @GetMapping("/addCredit")
    // 充值
    public boolean dealRequestAddCredit(@RequestParam(value = "type") String transactionType,
                                        @RequestParam(value = "id") String userID,
                                        @RequestParam(value = "money") Double money) {

        return moneyService.addCredit(transactionType, userID, money);
    }


}
