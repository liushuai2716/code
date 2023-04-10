package com.ls.code.valid.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ls.code.valid.annotation.IgnoreResponseAdvice;
import com.ls.code.valid.common.ResultVo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author: LS
 * @Date: 2023/4/7
 * @Description:
 * @version:
 **/
@RestControllerAdvice(basePackages = "com.ls.code.valid")
public class BaseResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * @param methodParameter 方法返回的类型
     * @param converterType   参数类型装换
     * @return 返回true 则调用 beforeBodyWrite方法
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        //返回类型为ResultVo 或者带有IgnoreResponseAdvice注解 则不进行包装
        return !(methodParameter.getParameterType().isAssignableFrom(ResultVo.class)
                || methodParameter.hasMethodAnnotation(IgnoreResponseAdvice.class));
    }

    @Override
    @SneakyThrows
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //String类型返回值单独处理
        if (data instanceof String) {
            return objectMapper.writeValueAsString(new ResultVo(data));
        }
        return ResultVo.success(data);
    }
}
