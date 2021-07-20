package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.StudentApplicationRecordBean;
import com.sevengroup.campus.bean.map.QueryForStudentMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentApplicationRecordMapper {
    List<StudentApplicationRecordBean> getStudentApplicationRecord(QueryForStudentMap queryForStudentMap);
}
