package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.ScoreRecordBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreRecordMapper {
    List<ScoreRecordBean> getStudentScore(String studentID);
}
