package com.sevengroup.campus.bean;

import lombok.Data;

@Data
public class UserBean {
    private String username;
    private String password;
    private String nickname;
    private String role;
    private String roomID;
}