package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.DmtManageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title: DmtManageMapper
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/21:15
 */

@Mapper
public interface DmtManageMapper {

    List<DmtManageBean> getInOutRecordsAll(String dormitoryID);

    String getUserRole(String userID);

    List<DmtManageBean> getInOutRecordsSelf(String userID);

    String getDmtID(String userID);
}
