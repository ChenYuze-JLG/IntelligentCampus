package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.ExamForStudentBean;

import java.util.List;

public interface ExamQueryService {
    List<ExamForStudentBean> examQuery(String studentID, String date);
}
