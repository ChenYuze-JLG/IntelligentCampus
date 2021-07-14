package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.UserBean;
import com.sevengroup.campus.mapper.UserMapper;
import com.sevengroup.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(String username, String password) {
        return userMapper.getInfo(username, password);
    }

}