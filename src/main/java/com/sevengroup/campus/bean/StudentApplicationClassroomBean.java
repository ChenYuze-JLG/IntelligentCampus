package com.sevengroup.campus.bean;

import lombok.Data;

@Data
public class StudentApplicationClassroomBean {
    private String classroomID;
    private String date;
    private String section;
    private String user;
    private String checkApplication;

    public StudentApplicationClassroomBean() {
    }

    public StudentApplicationClassroomBean(String classroomID, String date, String section, String user, String checkApplication) {
        this.classroomID = classroomID;
        this.date = date;
        this.section = section;
        this.user = user;
        this.checkApplication = checkApplication;
    }
}
