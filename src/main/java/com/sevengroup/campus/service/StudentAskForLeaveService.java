package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.AskForLeave.*;
import com.sevengroup.campus.bean.map.QueryForStudentMap;

import java.util.List;

public interface StudentAskForLeaveService {
    //获取教学班+课程信息
    List<TeachClassLessonInfoBean> queryTeachClassLessonInfoForStudent(String studentID, String date);

    //插入学生请假信息
    void insertStudentAskForLeaveInfo(StudentAskForLeaveInfoBean studentAskForLeaveInfoBean);

    //插入向老师发送的信息
    void insertLeaveApplicationMsg(LeaveApplicationMsg leaveApplicationMsg);
}
