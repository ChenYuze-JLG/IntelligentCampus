package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.AppBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppMapper {
    List<AppBean> listApps();
}
