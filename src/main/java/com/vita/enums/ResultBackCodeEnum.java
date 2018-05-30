package com.vita.enums;

import org.springframework.http.HttpStatus;

/**
 * Created by bobo on 2018/5/30.
 *
 * @email ruantianbo@163.com
 */
public enum ResultBackCodeEnum {

    STATE_OK(HttpStatus.OK,"调用成功"),
    AUTHOR_ERROR(HttpStatus.UNAUTHORIZED,"请先登陆"),
    PARAM_ERROR(HttpStatus.BAD_REQUEST,"请检查你输入都参数"),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"未知错误")
    ;


    private HttpStatus status;
    private String msg;

    ResultBackCodeEnum(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
