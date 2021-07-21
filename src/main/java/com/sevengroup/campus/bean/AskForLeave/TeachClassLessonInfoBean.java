package com.sevengroup.campus.bean.AskForLeave;

import lombok.Data;

@Data
public class TeachClassLessonInfoBean {
    private String teachClassID;
    private String teachClassName;
    private String teacherID;
    private String studentID;
    private String lessonID;
    private String lessonDate;
    private String lessonSection;

    public TeachClassLessonInfoBean() {
    }

    public TeachClassLessonInfoBean(String teachClassID, String teachClassName, String teacherID, String studentID, String lessonID, String lessonDate, String lessonSection) {
        this.teachClassID = teachClassID;
        this.teachClassName = teachClassName;
        this.teacherID = teacherID;
        this.studentID = studentID;
        this.lessonID = lessonID;
        this.lessonDate = lessonDate;
        this.lessonSection = lessonSection;
    }
}
