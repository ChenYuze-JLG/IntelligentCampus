package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.NewsBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    List<NewsBean> listNews();
    void saveNews(String author, String title, String info);
}
