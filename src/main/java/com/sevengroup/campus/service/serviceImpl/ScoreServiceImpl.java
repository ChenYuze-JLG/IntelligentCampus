package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.ScoreForStudentBean;
import com.sevengroup.campus.bean.map.QueryForStudentMap;
import com.sevengroup.campus.mapper.ScoreMapper;
import com.sevengroup.campus.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    //将DAO注入Service层
    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public List<ScoreForStudentBean> scoreSelect(String studentID, String date) {
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
//        System.out.println(startDate);
//        System.out.println(endDate);
        QueryForStudentMap queryForStudentMap = new QueryForStudentMap(studentID,startDate,endDate);
        return scoreMapper.getScore(queryForStudentMap);
    }

//    @Override
//    public List<ScoreBean> scoreSelect(String studentID){
//        return scoreMapper.getScore(studentID);
//    }
}
