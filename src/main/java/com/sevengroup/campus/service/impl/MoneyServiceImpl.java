package com.sevengroup.campus.service.impl;

import com.sevengroup.campus.bean.MoneyBean;
import com.sevengroup.campus.mapper.MoneyMapper;
import com.sevengroup.campus.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: MoneyService
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/18:53
 */

@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    MoneyMapper moneyMapper;

    @Override
    public boolean addCredit(String transactionType, String userID, double money) {
        MoneyBean moneyBean = new MoneyBean();
        moneyBean.setTransactionMoney(money);
        moneyBean.setUserID(userID);
        moneyBean.setTransactionType(transactionType);

        double balance = moneyMapper.findBalanceByID(userID);
        moneyBean.setCardBalance(balance);

        System.out.println(balance);

        if (transactionType.equals("校园卡充值")) {
            return moneyMapper.addCardCreditRecord(moneyBean) != 0;
        } else {
            return moneyMapper.addCreditRecord(moneyBean) != 0;
        }

    }
}
