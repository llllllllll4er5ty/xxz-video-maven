package com.leicx.xxz.service.impl;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.mapper.UsersMapper;
import com.leicx.xxz.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public void saveUser(UserEntity user) {
        Integer id = user.getId();
        if (id == null) {
            usersMapper.insert(user);
        } else {
            usersMapper.update(user);
        }
    }
}
