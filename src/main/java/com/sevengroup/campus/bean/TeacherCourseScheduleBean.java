package com.sevengroup.campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCourseScheduleBean {
    String teachClassName;
    String courseName;
    String lessonDate;
    String lessonSection;
    String TCStartDate;
    String TCEndDate;
}
