package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.AppBean;
import com.sevengroup.campus.mapper.AppMapper;
import com.sevengroup.campus.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    AppMapper appMapper;

    @Override
    public List<AppBean> listApps() {
        return appMapper.listApps();
    }
}
