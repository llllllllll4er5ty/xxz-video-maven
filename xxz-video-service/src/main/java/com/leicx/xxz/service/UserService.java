package com.leicx.xxz.service;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.vo.UserVO;

public interface UserService {

    /**
     * 插入用户
     * @param user 用户实体
     */
    void insertUser(UserEntity user);
    /**
     * 更新用户
     * @param user 用户实体
     */
    void updateUser(UserEntity user);

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

    /**
     * 根据用户名和密码获取用户实体
     * @param name  用户名
     * @param pwd   密码
     * @param del   删除标志，1：已删除，0：正常
     * @return 用户实体
     */
    UserEntity getUserByNameAndPwd(String name, String pwd, int del);

    /**
     * 根据用户名和密码判断用户是否存在
     * @param name  用户名
     * @param pwd   密码
     * @return true：存在；false：不存在
     */
    boolean userExistsByNameAndPwd(String name, String pwd);
    /**
     * 根据用户名和密码判断用户是否存在
     * @param name  用户名
     * @param pwd   密码
     * @param del   删除标志，1：已删除，0：正常
     * @return true：存在；false：不存在
     */
    boolean userExistsByNameAndPwd(String name, String pwd, int del);
    /**
     * 用户登录，将带有token信息的用户返回
     * @param userEntity  用户实体
     * @return true：存在；false：不存在
     */
    UserVO doLogin(UserEntity userEntity);

    /**
     * 保存用户
     * @param user 用户实体
     */
    UserVO saveUser(UserEntity user);
}
