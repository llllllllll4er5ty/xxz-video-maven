package com.leicx.xxz.mapper;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.util.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends IBaseMapper<UserEntity> {
    /**
     * 插入用户
     * @param user 用户实体
     */
    void insert(UserEntity user);

    void update(UserEntity user);

    UserEntity getUserByName(@Param("name") String name, @Param("del") int del);
}