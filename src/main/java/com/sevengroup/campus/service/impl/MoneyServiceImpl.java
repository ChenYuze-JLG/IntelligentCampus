package com.sevengroup.campus.service.impl;

import com.sevengroup.campus.bean.MoneyBean;
import com.sevengroup.campus.mapper.MoneyMapper;
import com.sevengroup.campus.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public MoneyBean addCredit(String userID, double money) {
        MoneyBean moneyBean = new MoneyBean();
        moneyBean.setTransactionMoney(money);
        moneyBean.setUserID(userID);
        moneyBean.setTransactionType("校园卡充值");

        double balance = moneyMapper.findBalanceByID(userID);
        moneyBean.setCardBalance(balance);

        if (moneyMapper.addCardCreditRecord(moneyBean) != 0) {
            moneyBean.setCardBalance(balance + money);
        }

        return moneyBean;
    }

    @Override
    public MoneyBean getBalance(String userID) {
        return moneyMapper.getBalanceByID(userID);
    }

    @Override
    public List<MoneyBean> getRecord(String userID) {
        return moneyMapper.getRecordByID(userID);
    }

    @Override
    public boolean payFromCard(String userID, String payType, double money) {

        if (moneyMapper.findBalanceByID(userID) >= money) {

//            System.out.println(moneyMapper.payFromCard(userID, payType, money));
            return moneyMapper.payFromCard(userID, payType, money) != 0;
        } else {
            return false;
        }
    }
}
