package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.ScoreRecordBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoreRecordMapper {
    ScoreRecordBean getStudentScore(String studentID);
}
