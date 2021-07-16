package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 教室申请记录
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CRApplicationRecordBean {
    private String classroomID;
    private String capacity;
    private String date;
    private String section;
    private String role;
    private String check;
}
