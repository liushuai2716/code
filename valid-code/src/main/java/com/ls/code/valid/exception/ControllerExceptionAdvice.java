package com.ls.code.valid.exception;

import com.ls.code.valid.common.ResultCode;
import com.ls.code.valid.common.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Throwables;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: LS
 * @Date: 2023/4/6
 * @Description:
 * @version:
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class ControllerExceptionAdvice {

    /**
     * 服务异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResultVo MethodArgumentNotValidExceptionHandler(Exception e) {
        log.error(Throwables.getStackTrace(e));
        return ResultVo.fail(ResultCode.ERROR_500, ResultCode.ERROR_500.getMsg(), e.getMessage());
    }

    /**
     * 参数校验异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler({BindException.class})
    public ResultVo MethodArgumentNotValidExceptionHandler(BindException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVo(ResultCode.ERROR_400, objectError.getDefaultMessage());
    }

    /**
     * 业务异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler({BusinessException.class})
    public ResultVo MethodArgumentNotValidExceptionHandler(BusinessException e) {
        return new ResultVo(e.getCode(), e.getMsg(), e.getMessage());
    }

}
