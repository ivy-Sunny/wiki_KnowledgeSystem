package com.ivy.wiki.resp;

import java.util.Map;

/**
 * ResultVo
 *
 * @Author: ivy
 * @CreateTime: 2021-07-22
 */
public class ResultVo<T> {
    private Integer code = 200;
    private String message = "success";
    private T data;

    public ResultVo() {

    }

    public ResultVo(String message) {
        this.message = message;
    }

    public ResultVo(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ResultVo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultVo(T data) {
        this.data = data;
    }
}
