package com.ls.code.valid.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: LS
 * @Date: 2023/4/6
 * @Description:
 * @version:
 **/
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {

    private int code;

    private String msg;

    private Object data;


    // 默认返回成功状态码，数据对象
    public ResultVo(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    // 返回指定状态码，数据对象
    public ResultVo(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    public ResultVo(ResultCode status, String msg, Object data) {
        this.code = status.getCode();
        this.msg = msg;
        this.data = data;
    }

    public static ResultVo success(Object data) {
        return new ResultVo(ResultCode.SUCCESS, data);
    }

    public static ResultVo fail(ResultCode status, String msg, Object data) {
        return new ResultVo(status, msg, data);
    }
}
