package com.leicx.xxz.exception;

import com.leicx.xxz.enums.ErrorCodeEnum;

/**
 * 自定义异常
 * @author daxiong
 * @date 2019-07-17 13:26
 **/
public class LcxException extends Exception {

    private static final long serialVersionUID = -3114017688962192849L;

    private Integer code;
    private String msg;

    public LcxException() {
        super();
    }

    public LcxException(Integer code, String msg) {
        super(code + " " + msg);
        this.code = code;
        this.msg = msg;
    }

    public LcxException(ErrorCodeEnum codeEnum) {
        this(codeEnum.getCode(), codeEnum.getMsg());
    }

    public LcxException(ErrorCodeEnum codeEnum, String msg) {
        this(codeEnum.getCode(), msg);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
