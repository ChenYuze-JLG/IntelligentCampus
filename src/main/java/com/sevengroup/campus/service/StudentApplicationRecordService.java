package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.StudentApplicationRecordBean;
import com.sevengroup.campus.bean.map.QueryForStudentMap;

import java.util.List;

public interface StudentApplicationRecordService {
    List<StudentApplicationRecordBean> queryStudentApplicationRecord(String studentID, String date);
}
