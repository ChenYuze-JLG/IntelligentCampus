package com.sevengroup.campus.bean;

import lombok.Data;

@Data
public class AbsenceRecordForStudentBean {
    private String studentID;
    private String studentName;
    private String courseName;
    private String teachClassName;
    private String absenceDate;
    private String absenceSection;
    private String absenceCondition;

    public AbsenceRecordForStudentBean() {
    }

    public AbsenceRecordForStudentBean(String studentID, String studentName, String courseName, String teachClassName, String absenceDate, String absenceSection, String absenceCondition) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.courseName = courseName;
        this.teachClassName = teachClassName;
        this.absenceDate = absenceDate;
        this.absenceSection = absenceSection;
        this.absenceCondition = absenceCondition;
    }

    @Override
    public String toString() {
        return "AbsenceRecordForStudentBean{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teachClassName='" + teachClassName + '\'' +
                ", absenceDate=" + absenceDate +
                ", absenceSection='" + absenceSection + '\'' +
                ", absenceCondition='" + absenceCondition + '\'' +
                '}';
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeachClassName() {
        return teachClassName;
    }

    public void setTeachClassName(String teachClassName) {
        this.teachClassName = teachClassName;
    }

    public String getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(String absenceDate) {
        this.absenceDate = absenceDate;
    }

    public String getAbsenceSection() {
        return absenceSection;
    }

    public void setAbsenceSection(String absenceSection) {
        this.absenceSection = absenceSection;
    }

    public String getAbsenceCondition() {
        return absenceCondition;
    }

    public void setAbsenceCondition(String absenceCondition) {
        this.absenceCondition = absenceCondition;
    }
}
