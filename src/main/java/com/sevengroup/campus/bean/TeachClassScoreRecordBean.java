package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachClassScoreRecordBean {
    private String studentID;
    private String studentName;
    private String collegeName;
    private String majorName;
    private String grade;
    private Integer classNumber;
    private Double courseScore;
}
