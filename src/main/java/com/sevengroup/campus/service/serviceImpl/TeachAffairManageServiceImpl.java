package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.*;
import com.sevengroup.campus.mapper.TeachAffairManageMapper;
import com.sevengroup.campus.service.TeachAffairManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachAffairManageServiceImpl implements TeachAffairManageService {
    @Autowired
    private TeachAffairManageMapper teachAffairManageMapper;

    // 获取某个教学班的成绩列表
    @Override
    public List<TeachClassScoreRecordBean> getTeachClassScoreRecord(String teachClassID) {
        return teachAffairManageMapper.getTeachClassScoreRecord(teachClassID);
    }

    // 获取教师管理的所有教学班信息
    @Override
    public List<TeachClassInfoBean> getTeachClassInfo(String teacherID) {
        return teachAffairManageMapper.getTeachClassInfo(teacherID);
    }

    @Override
    public List<TeachClassAbsenceRecordBean> getTeachClassAbsenceRecord(String teachClassID) {
        return teachAffairManageMapper.getTeachClassAbsenceRecord(teachClassID);
    }

    @Override
    public List<CRApplicationRecordBean> getCRApplicationRecord(String username) {
        return teachAffairManageMapper.getCRApplicationRecord(username);
    }

    @Override
    public List<TeacherCourseScheduleBean> getTeacherCourseSchedule(String teacherID) {
        return teachAffairManageMapper.getTeacherCourseSchedule(teacherID);
    }
}
