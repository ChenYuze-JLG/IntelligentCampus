package com.sevengroup.campus.bean;

import lombok.Data;

@Data
public class ScoreRecordBean {
    private Double score, credit;
    private String collegeID, courseID, teachClassID, studentID, teacherID;

    public ScoreRecordBean() {}

    public ScoreRecordBean(Double score, Double credit, String collegeID, String courseID,
                           String teachClassID, String studentID, String teacherID) {
        this.score = score;
        this.credit = credit;
        this.collegeID = collegeID;
        this.courseID = courseID;
        this.teachClassID = teachClassID;
        this.studentID = studentID;
        this.teacherID = teacherID;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTeachClassID() {
        return teachClassID;
    }

    public void setTeachClassID(String teachClassID) {
        this.teachClassID = teachClassID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

//    public static void main(String[] args) {
//        ArrayList<ScoreRecordBean> list = new ArrayList<ScoreRecordBean>();
//        ScoreRecordBean scoreRecordBean1 = new ScoreRecordBean(71.0, 2.0, "49872", "87587", "52216", "20159446", "20154176");
//        ScoreRecordBean scoreRecordBean2 = new ScoreRecordBean(72.0, 3.0, "49874", "87588", "52226", "20159546", "20174176");
//        ScoreRecordBean scoreRecordBean3 = new ScoreRecordBean(73.0, 4.0, "49875", "87589", "52236", "20159646", "20184176");
//        list.add(scoreRecordBean1);
//        list.add(scoreRecordBean2);
//        list.add(scoreRecordBean3);
//        SortUtil.anyProperSort(list, "credit", false);
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }
//    }

//    public String toString() {
//        String res = "";
//        res += "studentID: " + studentID + ", ";
//        res += "courseID: " + courseID + ", ";
//        res += "teachClassID: " + teachClassID + ", ";
//        res += "collegeID: " + collegeID + ", ";
//        res += "teacherID: " + teacherID + ", ";
//        res += "score: " + score + ", ";
//        res += "credit: " + credit + "; ";
//        return res;
//    }
}
