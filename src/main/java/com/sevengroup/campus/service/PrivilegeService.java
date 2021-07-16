package com.sevengroup.campus.service;

/**
 * @Title: PrivilegeService
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/16/20:08
 */
public interface PrivilegeService {


    boolean hasRight(String userID, String right);

    boolean addRight(String userID, String right);

    boolean delRight(String userID, String right);
}
