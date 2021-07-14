package com.sevengroup.campus.bean;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MsgBean {
    int ID;
    String type;
    String info;
    String sender;
    String receiver;
    Timestamp time;
    String url;
}
