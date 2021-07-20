package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.StudentApplicationClassroomBean;
import com.sevengroup.campus.mapper.StudentApplicationClassroomMapper;
import com.sevengroup.campus.service.StudentApplicationClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentApplicationClassroomImpl implements StudentApplicationClassroomService {
    //将DAO注入Service层
    @Autowired
    private StudentApplicationClassroomMapper studentApplicationClassroomMapper;

    @Override
    public List queryClassroomID(){
        return studentApplicationClassroomMapper.getClassroomID();
    }

    @Override
    public void insertApplicationClassroom(StudentApplicationClassroomBean studentApplicationClassroomBean) {
        studentApplicationClassroomMapper.insertApplicationClassroom(studentApplicationClassroomBean);
    }
}
