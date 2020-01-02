package com.mmall.common;

/**
 * Created by dengweiqiang on 2020/1/2
 */
public enum  ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGING(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
