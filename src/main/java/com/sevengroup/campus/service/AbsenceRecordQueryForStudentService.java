package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.AbsenceRecordForStudentBean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AbsenceRecordQueryForStudentService {
    List<AbsenceRecordForStudentBean> queryAbsenceForStudent(String studentID, String date);
}
