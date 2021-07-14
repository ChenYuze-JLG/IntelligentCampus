package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.MsgBean;
import com.sevengroup.campus.mapper.MsgMapper;
import com.sevengroup.campus.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MsgMapper msgMapper;

    @Override
    public void saveMsg(String type, Timestamp time, String info, String sender, String receiver, String url) {
        msgMapper.saveMsg(type, time, info, sender, receiver, url);
        System.out.println("msg");
        System.out.println(type);
        System.out.println(time);
        System.out.println(info);
        System.out.println(sender);
        System.out.println(receiver);
        System.out.println(url);
    }

    @Override
    public List<MsgBean> listMsgs(String username) {
        return msgMapper.listMsgs(username);
    }

}
