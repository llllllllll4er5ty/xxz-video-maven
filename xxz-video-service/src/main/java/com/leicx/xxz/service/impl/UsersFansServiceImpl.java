package com.leicx.xxz.service.impl;

import com.leicx.xxz.entity.UsersFans;
import com.leicx.xxz.mapper.UsersFansMapper;
import com.leicx.xxz.service.UsersFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsersFansServiceImpl implements UsersFansService {

    @Autowired
    private UsersFansMapper usersFansMapper;

    @Override
    public void insertUsersFans(UsersFans usersFans) {
        Date now = new Date();
        usersFans.setCreateTime(now);
        usersFans.setUpdateTime(now);
        usersFansMapper.insertSelective(usersFans);
    }

    @Override
    public void updateUsersFans(UsersFans usersFans) {
        Date now = new Date();
        usersFans.setUpdateTime(now);
        usersFansMapper.updateSelective(usersFans);
    }

    @Override
    public UsersFans getByUserIdAndFanId(Integer userId, Integer fanId) {
        return usersFansMapper.getByUserIdAndFanId(userId, fanId);
    }

    @Override
    public void cancelFollow(Integer userId, Integer followUserId) {
        UsersFans usersFans = getByUserIdAndFanId(userId, followUserId);
        usersFans.setDel(1);
        updateUsersFans(usersFans);
    }

    @Override
    public void saveUsersFans(UsersFans usersFans) {
        Integer id = usersFans.getId();
        if (id == null) {
            insertUsersFans(usersFans);
        } else {
            updateUsersFans(usersFans);
        }
    }
}
