package com.sevengroup.campus.serviceImpl;

import com.sevengroup.campus.bean.ScoreRecordBean;
import com.sevengroup.campus.mapper.ScoreRecordMapper;
import com.sevengroup.campus.service.ScoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreRecordImpl implements ScoreRecordService {
    @Autowired
    private ScoreRecordMapper scoreRecordMapper;

    @Override
    public ScoreRecordBean getStudentAll(String studentID) {
        return scoreRecordMapper.getStudentScore(studentID);
    }
}
