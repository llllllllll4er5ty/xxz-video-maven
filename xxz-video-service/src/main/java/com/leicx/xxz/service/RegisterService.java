package com.leicx.xxz.service;

import com.leicx.xxz.entity.UserEntity;

public interface RegisterService {

    /**
     * 保存用户
     * @param user 用户实体
     */
    void saveUser(UserEntity user);
}
