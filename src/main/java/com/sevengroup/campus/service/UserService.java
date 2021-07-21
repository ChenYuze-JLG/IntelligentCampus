package com.sevengroup.campus.service;


import com.sevengroup.campus.bean.UserBean;

public interface UserService {

    UserBean loginIn(String username, String password);

    boolean checkUserID(String userID);
}