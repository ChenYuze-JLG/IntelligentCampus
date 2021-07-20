package com.sevengroup.campus.bean.AskForLeave;

import lombok.Data;

@Data
public class StudentAskForLeaveInfoBean {
    private String lessonID;
    private String studentID;
    private String state;
    private String reason;

    public StudentAskForLeaveInfoBean() {
    }

    public StudentAskForLeaveInfoBean(String lessonID, String studentID, String state, String reason) {
        this.lessonID = lessonID;
        this.studentID = studentID;
        this.state = state;
        this.reason = reason;
    }
}
