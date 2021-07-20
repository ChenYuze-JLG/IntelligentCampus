package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.ExamForStudentBean;
import com.sevengroup.campus.bean.map.QueryForStudentMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamQueryMapper {
    List<ExamForStudentBean> getExamSchedule(QueryForStudentMap queryForStudentMap);
}
