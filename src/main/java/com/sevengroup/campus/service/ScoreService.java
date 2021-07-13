package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.ScoreForStudentBean;

import java.util.List;

public interface ScoreService {
    List<ScoreForStudentBean> scoreSelect(String studentID, String date);
}
