package com.sevengroup.campus.controller.tool;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title: tool
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/12/20:49
 */

public class Tool {

    public String getUserID(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("username");
    }
}
