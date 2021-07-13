package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.MoneyBean;
import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Title: MoneyController
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/18:53
 */

@RestController
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    private String currentUser = "20101106";

    private Tool tool = new Tool();

    // 返回余额
    @GetMapping("/getBalance")
    public MoneyBean dealRequestGetBalance(HttpServletRequest request) {
        String userID = tool.getUserID(request);

        return moneyService.getBalance(userID);
    }

    @GetMapping("/addCredit")
    // 充值成功后返回余额,否则返回原来余额
    public MoneyBean dealRequestAddCredit(@RequestParam(value = "money") Double money, HttpServletRequest request) {

        String userID = tool.getUserID(request);
//        String userID = "20101106";
        return moneyService.addCredit(userID, money);
    }

    // 返回消费记录
    @GetMapping("/getRecord")
    public List<MoneyBean> dealRequestGetRecord(HttpServletRequest request) {
        String userID = tool.getUserID(request);

        return moneyService.getRecord(userID);
    }


    // 从校园卡缴费
    @GetMapping("/payFromCard")
    public boolean dealRequestPayFromCard(@RequestParam(value = "payType") String payType,
                                          @RequestParam(value = "money") Double money, HttpServletRequest request){
        String userID = tool.getUserID(request);
//        userID = "20213941";
        return moneyService.payFromCard(userID, payType, money);
    }
}
