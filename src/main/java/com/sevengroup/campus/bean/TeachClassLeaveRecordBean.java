package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachClassLeaveRecordBean {
    public String studentID;
    public String studentName;
    public String collegeName;
    public String majorName;
    public String grade;
    public Integer classNumber;
    public String lessonID;
    public String date;
    public String section;
    public String state;
    public String reason;
}
