package com.sevengroup.campus.bean;

import java.util.ArrayList;
import java.util.List;

public class BookTableBean {
    private String code;
    private String msg;
    private int count;



    private List<BookBean> data;
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public List<BookBean> getData() {
        return data;
    }

    public void setData(List<BookBean> data) {
        this.data = data;
    }
}
