package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.CourseForStudentBean;
import com.sevengroup.campus.bean.map.QueryForStudentMap;
import com.sevengroup.campus.mapper.CourseScheduleQueryForStudentMapper;
import com.sevengroup.campus.service.CourseScheduleQueryForStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class CourseScheduleQueryForStudentImpl implements CourseScheduleQueryForStudentService {

    //将DAO注入Service层
    @Autowired
    private CourseScheduleQueryForStudentMapper courseScheduleQueryForStudentMapper;

    @Override
    public List<CourseForStudentBean> queryCourseInfoForStudent(String studentID, String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(date);
        Date startDate = null;
        Date endDate = null;
        try {
            endDate = new Date(sdf.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (endDate.getMonth() == 1){
            startDate = new Date(endDate.getYear()-1, 8-1, endDate.getDate());

        }else if (endDate.getMonth() == 7){
            startDate = new Date(endDate.getYear(), 2-1, endDate.getDate());
        }

        QueryForStudentMap queryForStudentMap = new QueryForStudentMap(studentID, startDate, endDate);
        return courseScheduleQueryForStudentMapper.getCourseInfoForStudent(queryForStudentMap);
    }

}
