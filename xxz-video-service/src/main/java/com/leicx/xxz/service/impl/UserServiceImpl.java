package com.leicx.xxz.service.impl;

import com.leicx.xxz.constant.SysConstant;
import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.mapper.UsersMapper;
import com.leicx.xxz.service.UserService;
import com.leicx.xxz.util.MD5Util;
import com.leicx.xxz.util.RedisUtils;
import com.leicx.xxz.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RedisUtils redisUtils;

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
    public UserVO doLogin(UserEntity userEntity) {
        // TODO 参数校验

        userEntity = getUserByNameAndPwd(userEntity.getName(), userEntity.getPassword(), 0);
        UserVO userVO = null;
        if (userEntity != null) {
            userVO = new UserVO();
            userVO.setUserEntity(userEntity);
            // 利用uuid获取token信息
            UUID uuid = UUID.randomUUID();
            String token = uuid.toString().replaceAll("-", "");
            userVO.setToken(token);

            // 将用户token存入redis
            redisUtils.set(SysConstant.REDIS_USER_TOKEN_KEY + ":" + userEntity.getId(), token, SysConstant.REDIS_KEY_TTL);
        }
        return userVO;
    }

    @Override
    public void doLogout(Integer userId) {
        redisUtils.del(SysConstant.REDIS_USER_TOKEN_KEY + ":" + userId);
    }

    @Override
    public UserVO saveUser(UserEntity user) {
        // 用户密码加密
        String password = user.getPassword();
        String md5 = MD5Util.EncoderByMd5(password);
        user.setPassword(md5);

        Integer id = user.getId();
        UserVO userVO = new UserVO();
        userVO.setUserEntity(user);
        if (id == null) {
            insertUser(user);

            // 利用uuid获取token信息
            UUID uuid = UUID.randomUUID();
            String token = uuid.toString().replaceAll("-", "");
            userVO.setToken(token);

            // 将用户token存入redis
            redisUtils.set(SysConstant.REDIS_USER_TOKEN_KEY + ":" + user.getId(), token, SysConstant.REDIS_KEY_TTL);

        } else {
            updateUser(user);
        }
        return userVO;
}

    @Override
    public boolean userExistsByNameAndPwd(String name, String pwd, int del) {
        UserEntity userEntity = getUserByNameAndPwd(name, pwd, del);
        return userEntity != null;
    }
}
