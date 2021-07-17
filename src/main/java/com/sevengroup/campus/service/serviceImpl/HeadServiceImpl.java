package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.controller.tool.Tool;
import com.sevengroup.campus.mapper.MsgMapper;
import com.sevengroup.campus.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class HeadServiceImpl implements HeadService {
    @Autowired
    MsgMapper msgMapper;

    @Autowired
    HttpServletRequest request;

    @Override
    public void showHeadInfo(Map<String, Object> map) {
        String username = (String) request.getSession().getAttribute("username");
        String role = (String) request.getSession().getAttribute("role");
        map.put("username", username);
        map.put("msgs", msgMapper.listMsgs(username));
        map.put("role", role);
        map.put("headPic", username.equals("") ? "#" : "../static/yln.jpg");
    }
}
