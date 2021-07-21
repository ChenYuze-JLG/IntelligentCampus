package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    // 查询教师课表
    List<TeacherCourseScheduleBean> getTeacherCourseSchedule(String teacherID);

    // 查询学生课表
    List<TeacherCourseScheduleBean> getStudentCourseSchedule(String teacherID);

    // 查询教学班级的请假记录
    List<TeachClassLeaveRecordBean> getTeachClassLeaveRecord(String teachClassID);

    // 查询学生假条信息（假条审核）
    List<TeachClassStudentLeaveInfoBean> getTeachClassStudentLeaveInfo(String studentID, String lessonID);

    // 更新学生请假状态
    int setStudentLeaveState(Map map);
}
