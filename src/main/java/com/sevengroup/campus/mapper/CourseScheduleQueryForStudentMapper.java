package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.CourseForStudentBean;
import com.sevengroup.campus.bean.map.QueryForStudentMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseScheduleQueryForStudentMapper {
    List<CourseForStudentBean> getCourseInfoForStudent(QueryForStudentMap queryForStudentMap);
}
