package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.AbsenceRecordForStudentBean;
import com.sevengroup.campus.bean.map.QueryForStudentMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AbsenceRecordQueryForStudentMapper {
    List<AbsenceRecordForStudentBean> getAbsenceForStudent(QueryForStudentMap queryForStudentMap);
}
