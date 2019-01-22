package com.lifengming.tybs.pojo.vo;

import java.util.List;

/**
 * Date:2018-04-03
 * 用于返回table数据
 * @author lifengming
 */
public class TableVo<T> {
    private int code;
    private String msg;
    private int count;
    List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
