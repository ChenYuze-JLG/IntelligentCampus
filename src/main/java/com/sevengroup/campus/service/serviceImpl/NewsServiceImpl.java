package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.NewsBean;
import com.sevengroup.campus.mapper.NewsMapper;
import com.sevengroup.campus.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<NewsBean> listNews() {
        return newsMapper.listNews();
    }

    @Override
    public void saveNews(String author, String title, String info) {
        newsMapper.saveNews(author, title, info);
    }
}
