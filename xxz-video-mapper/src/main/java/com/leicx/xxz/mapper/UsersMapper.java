package com.leicx.xxz.mapper;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.util.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UsersMapper extends IBaseMapper<UserEntity> {
    /**
     * 插入用户
     * @param user 用户实体
     */
    void insert(UserEntity user);

    void update(UserEntity user);

    UserEntity getUserByName(@Param("name") String name, @Param("del") int del);

    UserEntity getUserByNameAndPwd(@Param("name")String name, @Param("password") String pwd, @Param("del") int del);

    /**
     * 根据用户id获取用户实体
     * @param userId    用户id
     * @return  用户实体
     */
    UserEntity getUserById(@Param("id") Integer userId);
}