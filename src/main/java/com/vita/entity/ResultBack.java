package com.vita.entity;

/**
 * Created by bobo on 2018/5/30.
 *
 * @email ruantianbo@163.com
 */
public class ResultBack {
    private Integer code;
    private String msg;
    private Object backData;

    public ResultBack() {
    }

    public ResultBack(int code, String msg, Object backData) {
        this.code = code;
        this.msg = msg;
        this.backData = backData;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getBackData() {
        return backData;
    }

    public void setBackData(Object backData) {
        this.backData = backData;
    }
}
