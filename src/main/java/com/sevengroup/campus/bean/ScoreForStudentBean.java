package com.sevengroup.campus.bean;

public class ScoreForStudentBean {
    private double score;
    private double credit;
    private String courseName;
    private String teacher;
    private String teachClassName;
    //private String studentID;
    //private String teacherID;

    public ScoreForStudentBean() {
    }

    public ScoreForStudentBean(double score, double credit, String courseName, String teacher, String teachClassName) {
        this.score = score;
        this.credit = credit;
        this.courseName = courseName;
        this.teacher = teacher;
        this.teachClassName = teachClassName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeachClassName() {
        return teachClassName;
    }

    public void setTeachClassName(String teachClassName) {
        this.teachClassName = teachClassName;
    }
}
