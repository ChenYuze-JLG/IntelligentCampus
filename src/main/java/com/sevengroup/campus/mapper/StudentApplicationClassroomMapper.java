package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.StudentApplicationClassroomBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentApplicationClassroomMapper {
    List getClassroomID();

    void insertApplicationClassroom(StudentApplicationClassroomBean studentApplicationClassroomBean);
}
