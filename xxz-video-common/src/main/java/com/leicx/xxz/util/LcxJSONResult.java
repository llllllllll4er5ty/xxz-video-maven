package com.leicx.xxz.util;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LcxJSONResult {
    /**
     * 返回的状态码
     */
    private Integer code;
    /**
     * 返回的消息
     */
    private String msg;
    /**
     * 返回的内容
     */
    private Object data;

    private static final String SUCCESS = "success";
    private static final Integer SUCCESS_CODE = 200;
    private static final String ERROR = "error";
    private static final Integer ERROR_CODE = 500;

    public LcxJSONResult(Object o) {
        this.code = SUCCESS_CODE;
        this.msg = LcxJSONResult.SUCCESS;
        this.data = o;
    }
    public LcxJSONResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static LcxJSONResult ok(Object o) {
        return new LcxJSONResult(o);
    }

//    public static LcxJSONResult errorException(String msg) {
//        return new LcxJSONResult(ERROR_CODE, msg);
//    }
//
//    public static LcxJSONResult errorException(ErrorCodeEnum errorCodeEnum) {
//        return new LcxJSONResult(errorCodeEnum.getCode(), errorCodeEnum.getMsg());
//    }
//
//    public static LcxJSONResult errorException(ErrorCodeEnum errorCodeEnum, String msg) {
//        return new LcxJSONResult(errorCodeEnum.getCode(), errorCodeEnum.getMsg() + ":" + msg);
//    }

}
