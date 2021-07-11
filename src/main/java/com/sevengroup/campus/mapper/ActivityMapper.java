package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.ActivityBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    List<ActivityBean> listActivities();
}
