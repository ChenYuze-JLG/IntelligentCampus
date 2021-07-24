package com.sevengroup.campus.controller.tool;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Title: tool
 * @Description:
 * @Author: iflysQin/ qyp
 * @Date: 2021/7/12/20:49
 */

@Component
public class Tool {

    public static String getUserID(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("username");
    }

    public static String getMD5Str(String str) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest  = md5.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        return new BigInteger(1, digest).toString(16);
    }

}
