package com.guocz.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guocz
 * @date 2022/8/30 14:14
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 6273326371984994386L;

    private Integer code;

    private String msg;

    private T data;

    private Result() {
        this.code = 200;
        this.msg = "OK";
    }

    private Result(T data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }

    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result<T> setError(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public boolean isSuccess() {
        return this.getCode().equals(200);
    }

    public static Result ok() {
        return new Result();
    }

    public static <T> Result ok(T data) {
        return new Result(data);
    }

    public static <T> Result ok(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static <T> Result ok(Integer code, String msg, T data) {
        return new Result(code, msg, data);
    }

    public static <T> Result error() {
        return new Result(500, "failed");
    }

    public static <T> Result error(String msg) {
        return new Result(500, msg);
    }

    public static <T> Result error(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static <T> Result error(Integer code, String msg, T data) {
        return new Result(code, msg, data);
    }

}
