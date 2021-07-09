package com.sevengroup.campus.service;


import com.sevengroup.campus.bean.UserBean;

public interface UserService {

    UserBean loginIn(String name, String password);

}