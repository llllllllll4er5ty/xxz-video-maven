package com.leicx.xxz.constant;

/**
 * 系统级别的常量
 */
public class SysConstant {
    /**
     * 集合默认初始值16
     */
    public static final int COLLECTION_DEFAULT_CAPACITY = 1 << 4;
    /**
     * 用户token在redis中的key
     */
    public static final String REDIS_USER_TOKEN_KEY = "REDIS_USER_TOKEN_KEY";

    /**
     * redis的key的存活时间，30min
     */
    public static final int REDIS_KEY_TTL = 1000 * 60 *30;
    /**
     * 视频临时存储位置，前缀
     */
    public static final String TEMP_VIDEO_PATH_REFIX = "/Users/daxiong/lcx/xxz-static/temp-video";
    /**
     * 音频存储位置，前缀
     */
    public static final String STATIC_PATH_REFIX = "/Users/daxiong/lcx/xxz-static";

}
