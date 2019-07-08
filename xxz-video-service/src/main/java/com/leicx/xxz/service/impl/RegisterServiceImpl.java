package com.leicx.xxz.service.impl;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.service.RegisterService;
import com.leicx.xxz.service.UserService;
import com.leicx.xxz.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserService userService;


    @Override
    public void saveUser(UserEntity user) {
        // 用户密码加密
        String password = user.getPassword();
        String md5 = MD5Util.EncoderByMd5(password);
        user.setPassword(md5);

        Integer id = user.getId();
        if (id == null) {
            userService.insertUser(user);
        } else {
            userService.updateUser(user);
        }
    }


}
