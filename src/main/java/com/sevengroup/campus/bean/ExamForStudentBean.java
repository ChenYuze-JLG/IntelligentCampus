package com.sevengroup.campus.bean;


import java.util.Date;

public class ExamForStudentBean {
    private String courseID;
    private String courseName;
    private Date startExamTime;
    private int examTime;
    private String classroomID;

    public ExamForStudentBean() {
    }

    public ExamForStudentBean(String courseID, String courseName, Date startTime, int examTime, String classroomID) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.startExamTime = startTime;
        this.examTime = examTime;
        this.classroomID = classroomID;
    }

    @Override
    public String toString() {
        return "ExamForStudentBean{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", startExamTime=" + startExamTime +
                ", examTime=" + examTime +
                ", classroomID='" + classroomID + '\'' +
                '}';
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartExamTime() {
        return startExamTime;
    }

    public void setStartExamTime(Date startExamTime) {
        this.startExamTime = startExamTime;
    }

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }

    public int getExamTime() {
        return examTime;
    }

    public void setExamTime(int examTime) {
        this.examTime = examTime;
    }
}
