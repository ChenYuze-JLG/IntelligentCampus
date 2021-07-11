package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.ScoreRecordBean;

import java.util.List;

public interface ScoreRecordService {
    List<ScoreRecordBean> getStudentAll(String studentID);
}
