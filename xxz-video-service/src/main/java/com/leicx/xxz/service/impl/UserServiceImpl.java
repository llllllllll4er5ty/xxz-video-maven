package com.leicx.xxz.service.impl;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.mapper.UsersMapper;
import com.leicx.xxz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

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
        UserEntity userEntity = usersMapper.getUserByName(name, del);
        return userEntity != null;
    }
}
