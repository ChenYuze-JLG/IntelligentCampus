package com.sevengroup.campus.service.impl;

import com.sevengroup.campus.mapper.PrivilegeMapper;
import com.sevengroup.campus.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: PrivilegeServiceImpl
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/16/20:09
 */

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    PrivilegeMapper privilegeMapper;

    @Override
    public boolean hasRight(String userID, String right) {
        try {
            int res = privilegeMapper.hasRight(userID, right);
            return res == 1;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addRight(String userID, String right) {
        try {
            return privilegeMapper.addRight(userID, right);
        }catch (Exception e){
            privilegeMapper.addColomn(right);
            return privilegeMapper.addRight(userID, right);
        }
    }

    @Override
    public boolean delRight(String userID, String right) {

        return privilegeMapper.delRight(userID, right);
    }
}
