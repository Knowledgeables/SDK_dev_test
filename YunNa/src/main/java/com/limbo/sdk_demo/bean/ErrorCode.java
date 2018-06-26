package com.limbo.sdk_demo.bean;

/**
 * Created by wangqi on 2018/5/4.
 */

public class ErrorCode extends Throwable {
    private int code;
    private String msg;

    public ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
