package com.leicx.xxz.service.impl;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.mapper.UsersMapper;
import com.leicx.xxz.service.UserService;
import com.leicx.xxz.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void insertUser(UserEntity user) {
        // 创建时间和更新时间
        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        usersMapper.insert(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        user.setUpdateTime(new Date());
        usersMapper.update(user);
    }

    @Override
    public UserEntity getUserByName(String name, int del) {
        return usersMapper.getUserByName(name, del);
    }

    @Override
    public boolean userExistsByName(String name) {
        return userExistsByName(name, 0);
    }

    @Override
    public boolean userExistsByName(String name, int del) {
        UserEntity userEntity = getUserByName(name, del);
        return userEntity != null;
    }

    @Override
    public UserEntity getUserByNameAndPwd(String name, String pwd, int del) {
        // 密码进行md5转换
        pwd = MD5Util.EncoderByMd5(pwd);
        return usersMapper.getUserByNameAndPwd(name, pwd, del);
    }


    @Override
    public boolean userExistsByNameAndPwd(String name, String pwd) {
        return userExistsByNameAndPwd(name, pwd, 0);
    }

    @Override
    public boolean userExistsByNameAndPwd(String name, String pwd, int del) {
        UserEntity userEntity = getUserByNameAndPwd(name, pwd, del);
        return userEntity != null;
    }
}
