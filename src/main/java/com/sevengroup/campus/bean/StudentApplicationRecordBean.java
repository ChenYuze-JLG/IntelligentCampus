package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentApplicationRecordBean {
    private String classroomID;
    private String capacity;
    private String date;
    private String section;
    private String username;
    private String role;
    private String checkApplication;
}
