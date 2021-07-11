package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: DmtRoomBean
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/11/19:26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DmtManageBean {

    private String DMTID; // 宿舍楼栋id

    private String DMTName; // 宿舍楼栋名称

    private String username; // 进出用户昵称

    private String userID; // 用户ID

    private String inTime; // 进入时间

    private String outTime; // 出去时间
}
