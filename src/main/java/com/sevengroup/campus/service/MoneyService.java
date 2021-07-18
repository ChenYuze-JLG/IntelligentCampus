package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.MoneyBean;

import java.util.List;

/**
 * @Title: MoneyService
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/18:53
 */
public interface MoneyService {
    /**
     *
     * @param userID 用户id
     * @param money 交易金额
     * @return 返回余额
     */
    MoneyBean addCredit(String userID, double money);

    /**
     * 返回当前用户的账户余额
     * @param userID 用户id
     * @return 返回当前用户信息
     */
    MoneyBean getCardBalance(String userID);

    /**
     *
     * @param userID 用户id
     * @return 交易记录list
     */
    List<MoneyBean> getRecord(String userID);

    /**
     *
     * @param userID 用户id
     * @param payType 缴费类型
     * @param money
     * @return 返回成功与否
     */
    boolean payFromCard(String userID, String payType, double money);

    MoneyBean getCAllBalance(String userID);
}
