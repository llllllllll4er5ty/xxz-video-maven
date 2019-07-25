package com.leicx.xxz.service;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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
     * 根据用户id获取用户实体
     * @param userId  用户id
     * @return 用户实体
     */
    UserEntity getUserById(Integer userId);
    /**
     * 获取用户实体列表
     * @param params  参数集合
     * @return 用户实体
     */
    List<UserEntity> getUserList(Map<String, Object> params);

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

    /**
     * 用户登出，删除token信息
     * @param userId
     * @return
     */
    void doLogout(Integer userId);

    /**
     * 上传用户头像到服务器（本地）
     * @param userId    用户id
     * @param files     文件数组
     * @return string   用头头像在db中的存储路径
     */
    String saveUserAvatar(Integer userId, MultipartFile files);

    /**
     * 关注用户
     * @author daxiong
     * @date 2019-07-25 15:14
     * @param userId    被关注用户的id
     * @param followUserId  关注者id
     * @return UserEntity 被关注用户实体
     **/
    UserEntity followUser(Integer userId, Integer followUserId);
    /**
     * 取消关注用户
     * @author daxiong
     * @date 2019-07-25 15:14
     * @param userId    被关注用户的id
     * @param followUserId  关注者id
     * @return UserEntity 被关注用户实体
     **/
    UserEntity unFollowUser(Integer userId, Integer followUserId);
    /**
     * 判断是否已经关注
     * @author daxiong
     * @date 2019-07-25 15:14
     * @param userId    被关注用户的id
     * @param followUserId  关注者id
     * @return UserEntity 被关注用户实体
     **/
    boolean isFollow(Integer userId, Integer followUserId);
}
