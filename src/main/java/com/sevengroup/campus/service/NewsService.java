package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.NewsBean;
import com.sevengroup.campus.mapper.NewsMapper;

import java.util.List;

public interface NewsService {
    List<NewsBean> listNews();
    void saveNews(String author, String title, String info);
}
