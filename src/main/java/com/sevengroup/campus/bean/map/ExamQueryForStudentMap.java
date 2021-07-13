package com.sevengroup.campus.bean.map;

import java.sql.Date;

public class ExamQueryForStudentMap {
    private String studentID;
    private Date startDate;
    private Date endDate;

    public ExamQueryForStudentMap() {
    }

    public ExamQueryForStudentMap(String studentID, Date startDate, Date endDate) {
        this.studentID = studentID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
