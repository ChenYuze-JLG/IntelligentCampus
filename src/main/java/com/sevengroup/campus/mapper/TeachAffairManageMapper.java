package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.CRApplicationRecordBean;
import com.sevengroup.campus.bean.TeachClassAbsenceRecordBean;
import com.sevengroup.campus.bean.TeachClassScoreRecordBean;
import com.sevengroup.campus.bean.TeachClassInfoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeachAffairManageMapper {
    // 获取某个教学班的成绩列表
    List<TeachClassScoreRecordBean> getTeachClassScoreRecord(String teachClassID);
    
    // 根据教师ID获取教师所有教学班级的信息
    List<TeachClassInfoBean> getTeachClassInfo(String teacherID);

    // 获取某个教学班的考勤记录
    List<TeachClassAbsenceRecordBean> getTeachClassAbsenceRecord(String teachClassID);

    // 获取某user的教室申请记录
    List<CRApplicationRecordBean> getCRApplicationRecord(String username);
}
