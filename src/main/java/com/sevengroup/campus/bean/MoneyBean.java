package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: MoneyBean
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/18:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyBean {

    private String UserID; // 用户ID

    private String username; // 用户名

    private double cardBalance = 0; // 校园卡余额

    private double waterBalance = 0; // 水费余额

    private double gasBalance = 0; // 气费余额

    private double electricBalance = 0; // 电费余额

    private String payTime; // 交易时间

    private double transactionMoney = 0; // 交易金额

    private String transactionType; // 交易类型
}
