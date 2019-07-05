package com.leicx.xxz.service;

import com.leicx.xxz.entity.UserEntity;

public interface UserService {

    /**
     * 根据用户名获取用户实体
     * @param name  用户名
     * @param del   删除标志，1：已删除，0：正常
     * @return 用户实体
     */
    UserEntity getUserByName(String name, int del);

    /**
     * 根据用户名判断用户是否存在
     * @param name  用户名
     * @return true：存在；false：不存在
     */
    boolean userExistsByName(String name);
    /**
     * 根据用户名判断用户是否存在
     * @param name  用户名
     * @param del   删除标志，1：已删除，0：正常
     * @return true：存在；false：不存在
     */
    boolean userExistsByName(String name, int del);
}
