package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.MoneyBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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

    MoneyBean getBalanceByID(String userID);

    List<MoneyBean> getRecordByID(String userID);

    int payFromCard(@Param("userID") String userID,@Param("payType") String payType, @Param("money") double money);
}
