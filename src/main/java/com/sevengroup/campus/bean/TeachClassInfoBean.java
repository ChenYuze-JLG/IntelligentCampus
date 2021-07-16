package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachClassInfoBean {
    String collegeName;
    String courseName;
    String teachClassID;
    String teachClassName;
    String teachStartDate;
    String teachEndDate;
    String courseCredit;
    String teachClassCapacity;
}
