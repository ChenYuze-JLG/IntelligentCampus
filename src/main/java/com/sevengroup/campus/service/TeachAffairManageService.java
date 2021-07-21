package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.*;

import java.util.List;
import java.util.Map;

public interface TeachAffairManageService {
    // 获取某个教学班的成绩列表
    List<TeachClassScoreRecordBean> getTeachClassScoreRecord(String teachClassID);

    // 获取教师管理的所有教学班信息
    List<TeachClassInfoBean> getTeachClassInfo(String teacherID);

    // 获取某个教学班的考勤记录
    List<TeachClassAbsenceRecordBean> getTeachClassAbsenceRecord(String teachClassID);

    // 获取某user的教室申请记录
    List<CRApplicationRecordBean> getCRApplicationRecord(String username);

    // 查询教师课表
    List<TeacherCourseScheduleBean> getTeacherCourseSchedule(String teacherID);

    // 查询学生课表
    List<TeacherCourseScheduleBean> getStudentCourseSchedule(String teacherID);

    // 查询教学班课程请假记录
    List<TeachClassLeaveRecordBean> getTeachClassLeaveRecord(String teachClassID);

    // 查询学生假条信息（假条审核）
    List<TeachClassStudentLeaveInfoBean> getTeachClassStudentLeaveInfo(String studentID, String lessonID);

    // 设置学生请假状态
    int setStudentLeaveState(Map map);
}
