package com.sevengroup.campus.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: PrivilegeMapper
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/16/20:08
 */
@Mapper
public interface PrivilegeMapper {


    int hasRight(String userID, String right);

    boolean addRight(String userID, String right);

    boolean delRight(String userID, String right);

    void addColomn(String right);
}
