package com.sevengroup.campus.mapper;


import com.sevengroup.campus.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserBean getInfo(String username, String password);

    boolean checkUserID(String userID);
}