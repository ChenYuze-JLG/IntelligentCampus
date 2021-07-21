package com.sevengroup.campus.bean.AskForLeave;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LeaveApplicationMsg {
    String type;
    String info;
    String sender;
    String receiver;

    public LeaveApplicationMsg() {
    }

    public LeaveApplicationMsg(String type, String info, String sender, String receiver) {
        this.type = type;
        this.info = info;
        this.sender = sender;
        this.receiver = receiver;
    }
}
