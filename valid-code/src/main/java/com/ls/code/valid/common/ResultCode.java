package com.ls.code.valid.common;

import lombok.Getter;

/**
 * @author: LS
 * @Date: 2023/4/6
 * @Description:
 * @version:
 **/
@Getter
public enum ResultCode implements StatusCode {
    SUCCESS(1, "请求成功"),
    FAIL(-1, "操作失败"),

    ERROR_500(500, "服务器未知错误"),
    ERROR_400(400, "错误请求");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
