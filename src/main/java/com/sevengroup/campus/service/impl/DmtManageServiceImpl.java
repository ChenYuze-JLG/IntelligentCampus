package com.sevengroup.campus.service.impl;

import com.sevengroup.campus.bean.DmtManageBean;
import com.sevengroup.campus.mapper.DmtManageMapper;
import com.sevengroup.campus.service.DmtManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Title: DmtManageServiceImpl
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/21:15
 */

@Service
public class DmtManageServiceImpl implements DmtManageService {

    @Autowired
    DmtManageMapper dmtManageMapper;

    @Override
    public List<DmtManageBean> getInOutRecords(String userID) {
        String userRole = dmtManageMapper.getUserRole(userID);
        String dormitoryID = dmtManageMapper.getDmtID(userID);

        if (userRole.equals("舍区管理员")) {
            System.out.println("舍区管理员");
            System.out.println(dormitoryID);
            return dmtManageMapper.getInOutRecordsAll(dormitoryID);
        }
        else {
            System.out.println("非舍区管理员");
            System.out.println(dormitoryID);
            return  dmtManageMapper.getInOutRecordsSelf(userID);
        }

    }
}
