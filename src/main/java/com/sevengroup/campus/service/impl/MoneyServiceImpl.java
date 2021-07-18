package com.sevengroup.campus.service.impl;

import com.sevengroup.campus.bean.MoneyBean;
import com.sevengroup.campus.mapper.MoneyMapper;
import com.sevengroup.campus.service.MoneyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Title: MoneyService
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/18:53
 */

@Service
@Slf4j
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    MoneyMapper moneyMapper;

    @Override
    @Transactional
    public MoneyBean addCredit(String userID, double money) {
        MoneyBean moneyBean = new MoneyBean();
        moneyBean.setTransactionMoney(money);
        moneyBean.setUserID(userID);
        moneyBean.setTransactionType("校园卡充值");

        double balance = moneyMapper.getCardBalanceByID(userID);
        moneyBean.setCardBalance(balance);

        try {
            if (moneyMapper.addCardCreditRecord(moneyBean) != 0) {
                moneyBean.setCardBalance(balance + money);
            }
        }
        catch (Exception e){
            log.error("【error】:", e);
            return new MoneyBean();
        }

        return moneyBean;
    }

    @Override
    public MoneyBean getCardBalance(String userID) {
        return moneyMapper.getCardBalance(userID);
    }

    @Override
    public List<MoneyBean> getRecord(String userID) {
        return moneyMapper.getRecordByID(userID);
    }

    @Override
    @Transactional
    public boolean payFromCard(String userID, String payType, double money) {
        System.out.println(moneyMapper.getCardBalanceByID(userID));
        if (moneyMapper.getCardBalanceByID(userID) >= money) {
            try {
                System.out.println(payType);
                String insertPara;
                switch (payType) {
                    case "燃气费":
                        insertPara = "gasBalance";
                        break;
                    case "电费":
                        insertPara = "electricBalance";
                        break;
                    case "水费":
                        insertPara = "waterBalance";
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + payType);
                }
                return moneyMapper.payFromCard(userID, payType, money, insertPara) != 0;
            } catch (Exception e) {
                log.error("【error】:", e);
                System.out.println(e);
                return false;
            }
        } else {
            System.out.println("else");
            return false;
        }
    }

    @Override
    public MoneyBean getCAllBalance(String userID) {
        return moneyMapper.getAllBalance(userID);
    }
}
