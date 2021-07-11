package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.MoneyBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Title: MoneyMapper
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/18:53
 */

@Mapper
@Component
public interface MoneyMapper {
    int addCreditRecord(MoneyBean moneyBean);

    int addCardCreditRecord(MoneyBean moneyBean);


    double findBalanceByID(String userID);
}
