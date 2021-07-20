package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.ScoreForStudentBean;
import com.sevengroup.campus.bean.map.QueryForStudentMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {
    List<ScoreForStudentBean> getScore(QueryForStudentMap queryForStudentMap);
}
