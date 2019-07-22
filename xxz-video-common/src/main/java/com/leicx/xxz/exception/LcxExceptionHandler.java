package com.leicx.xxz.exception;

import com.leicx.xxz.util.LcxJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller层的全局异常处理
 */
@RestControllerAdvice
public class LcxExceptionHandler {

    /**
     * @author daxiong
     * @date 2019-06-18 16:29
     * @param request
     * @param response
     * @param e
     * @return com.leicx.util.LcxJSONResult
     **/
    @ExceptionHandler(value = Exception.class)
    public LcxJSONResult errorHandler(HttpServletRequest request,
                                      HttpServletResponse response, Exception e) {
        e.printStackTrace();

        return LcxJSONResult.errorException(e.getMessage());
    }
}
