package com.mmall.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * Created by dengweiqiang on 2020/1/2
 */
// 保证序列化json的时候，不会序列化值为 null的key
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    private ServerResponse() {
    }

    private ServerResponse(int status) {
        this(status, null, null);
    }

    private ServerResponse(int status, T data) {
        this(status, null, data);
    }

    private ServerResponse(int status, String msg) {
        this(status, msg, null);
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // 不序列化此方法
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<>(errorCode, errorMessage);
    }

}
