package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.MsgBean;

import java.sql.Timestamp;
import java.util.List;

public interface MsgService {
    void saveMsg(String type, Timestamp time, String info, String sender,
                 String receiver, String url);
    List<MsgBean> listMsgs(String username);
    List<MsgBean> allMsgs(String username);
    void setHandled(String id);

//    List<MsgBean>
}
