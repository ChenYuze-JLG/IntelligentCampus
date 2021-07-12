package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.DmtManageBean;

import java.util.List;

/**
 * @Title: DmtManageService
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/21:15
 */


public interface DmtManageService {
    List<DmtManageBean> getInOutRecords(String dormitoryID);

}
