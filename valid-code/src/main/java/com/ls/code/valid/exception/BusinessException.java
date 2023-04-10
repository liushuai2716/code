package com.ls.code.valid.exception;

import com.ls.code.valid.common.ResultCode;
import lombok.Getter;

/**
 * @author: LS
 * @Date: 2023/4/7
 * @Description: 自定义业务异常
 * @version:
 **/
@Getter
public class BusinessException extends RuntimeException {
    private Integer code;
    private String msg;

    public BusinessException(ResultCode resultCode, String message) {
        //设置错误详情
        super(message);
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public BusinessException(String message) {
        super(message);
        this.code = ResultCode.FAIL.getCode();
        this.msg = ResultCode.FAIL.getMsg();
    }
}
