package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.MsgBean;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface MsgMapper {
    void saveMsg(String type, Timestamp time, String info, String sender,
                 String receiver, String url);
    List<MsgBean> listMsgs(String username);
}
