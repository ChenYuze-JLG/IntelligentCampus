package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachClassAbsenceRecordBean {
    private Integer classNumber;
    private String studentID;
    private String studentName;
    private String collegeName;
    private String majorName;
    private String grade;
    private String date;
    private String section;
    private String type;
}
