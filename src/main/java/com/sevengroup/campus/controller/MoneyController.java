package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.MoneyBean;
import com.sevengroup.campus.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    private String currentUser = "20101106";

    // 返回余额
    @GetMapping("/getBalance")
    public MoneyBean dealRequestGetBalance() {
        return moneyService.getBalance(currentUser);
    }

    @GetMapping("/addCredit")
    // 充值成功后返回余额,否则返回原来余额
    public MoneyBean dealRequestAddCredit(@RequestParam(value = "money") Double money) {

        return moneyService.addCredit(currentUser, money);
    }

    // 返回消费记录
    @GetMapping("/getRecord")
    public List<MoneyBean> dealRequestGetRecord() {
        return moneyService.getRecord(currentUser);
    }


    // 从校园卡缴费
    @GetMapping("/payFromCard")
    public boolean dealRequestPayFromCard(@RequestParam(value = "payType") String payType,
                                          @RequestParam(value = "money") Double money){
        return moneyService.payFromCard(currentUser, payType, money);
    }
}
