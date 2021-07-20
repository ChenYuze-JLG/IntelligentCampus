package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.AskForLeave.*;
import com.sevengroup.campus.bean.map.QueryForStudentMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentAskForLeaveMapper {

    //获取教学班+课程信息
    List<TeachClassLessonInfoBean> getTeachClassLessonInfo(QueryForStudentMap queryForStudentMap);

    //插入请假申请信息
    void insertStudentAskForLeaveInfo(StudentAskForLeaveInfoBean studentAskForLeaveInfoBean);

    //插入向老师发送的信息
    void insertLeaveApplicationMessage(LeaveApplicationMsg leaveApplicationMsg);
}
