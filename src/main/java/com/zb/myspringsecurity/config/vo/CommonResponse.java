package com.zb.myspringsecurity.config.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zb
 * @since 2021/6/18
 */
@Data
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 3614634366464358186L;
    private T data;
    private Integer code;
    private String msg;

    public static <T> CommonResponse<T> successWithData(T data) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(200);
        response.setMsg("ok");
        response.setData(data);
        return response;
    }

    public static <T> CommonResponse<T> fail(Integer code, String message) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(code);
        response.setMsg(message);
        return response;
    }
}
