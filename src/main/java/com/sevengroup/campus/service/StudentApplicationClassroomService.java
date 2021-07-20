package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.StudentApplicationClassroomBean;

import java.util.List;

public interface StudentApplicationClassroomService {
    List queryClassroomID();

    void insertApplicationClassroom(StudentApplicationClassroomBean studentApplicationClassroomBean);
}
