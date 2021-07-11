package com.sevengroup.campus.service;

/**
 * @Title: MoneyService
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/18:53
 */
public interface MoneyService {
    /**
     *
     * @param transactionType 交易类型
     * @param userID 用户id
     * @param money 交易金额
     * @return 返回是否成功添加
     */
    boolean addCredit(String transactionType, String userID, double money);
}
