package com.leicx.xxz.enums;

import lombok.Getter;

/**
 * 错误枚举
 * 100 系统级错误
 * 200用户级错误
 */
@Getter
public enum ErrorCodeEnum {
    // 系统级错误
    ERROR_CODE_100001(100001, "系统错误"),
    ERROR_CODE_100002(100002, "参数错误"),

    // 用户级错误
    ERROR_CODE_200001(200001, "用户不能为空"),
    ERROR_CODE_200002(200002, "用户名和密码不能为空"),
    ERROR_CODE_200003(200003, "用户名已存在，请重新输入"),
    ERROR_CODE_200004(200004, "用户名或密码错误，请重新输入"),


    ;

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
