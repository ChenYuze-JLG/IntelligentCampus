package com.sevengroup.campus.bean;

import lombok.Data;

@Data
public class CourseForStudentBean {
    private String courseID;
    private String courseName;
    private String teacherName;
    private String classroomID;
    private String section;
    private String lessonDate;

    public CourseForStudentBean() {
    }

    public CourseForStudentBean(String courseID, String courseName, String teacherName, String classroomID, String section, String lessonDate) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.classroomID = classroomID;
        this.section = section;
        this.lessonDate = lessonDate;
    }



    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(String lessonDate) {
        this.lessonDate = lessonDate;
    }
}
