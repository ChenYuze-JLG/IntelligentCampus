package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.CourseForStudentBean;

import java.util.List;

public interface CourseScheduleQueryForStudentService {
    List<CourseForStudentBean> queryCourseInfoForStudent(String studentID, String date);
}
