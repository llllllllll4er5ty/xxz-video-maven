package com.leicx.xxz.constant;

/**
 * 系统级别的常量
 */
public class SysConstant {
    /**
     * 用户token在redis中的key
     */
    public static final String REDIS_USER_TOKEN_KEY = "REDIS_USER_TOKEN_KEY";

    /**
     * redis的key的存活时间，30min
     */
    public static final int REDIS_KEY_TTL = 1000 * 60 *30;


}
