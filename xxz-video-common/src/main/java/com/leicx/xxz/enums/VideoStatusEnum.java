package com.leicx.xxz.enums;

import lombok.Getter;

/**
 * 视频状态的枚举
 * @author daxiong
 * @date 2019-07-19 09:39
 **/
@Getter
public enum VideoStatusEnum {
    //
    NORMAL(1, "正常"),
    PROHIBITION(2, "禁播"),
    APPROVING(3, "审核中"),
    ;

    private int code;
    private String msg;
    VideoStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
