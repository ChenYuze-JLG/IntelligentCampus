package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.CRApplicationRecordBean;
import com.sevengroup.campus.bean.TeachClassAbsenceRecordBean;
import com.sevengroup.campus.bean.TeachClassScoreRecordBean;
import com.sevengroup.campus.bean.TeachClassInfoBean;

import java.util.List;

public interface TeachAffairManageService {
    // 获取某个教学班的成绩列表
    List<TeachClassScoreRecordBean> getTeachClassScoreRecord(String teachClassID);

    // 获取教师管理的所有教学班信息
    List<TeachClassInfoBean> getTeachClassInfo(String teacherID);

    // 获取某个教学班的考勤记录
    List<TeachClassAbsenceRecordBean> getTeachClassAbsenceRecord(String teachClassID);

    // 获取某user的教室申请记录
    List<CRApplicationRecordBean> getCRApplicationRecord(String username);
}
