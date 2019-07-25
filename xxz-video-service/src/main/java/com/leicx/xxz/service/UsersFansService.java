package com.leicx.xxz.service;

import com.leicx.xxz.entity.UsersFans;

public interface UsersFansService {

    /**
     * 传入关注用户
     * @param usersFans
     */
    void insertUsersFans(UsersFans usersFans);
    /**
     * 更新关注用户
     * @param usersFans
     */
    void updateUsersFans(UsersFans usersFans);
    /**
     * 根据userId和fanId获取实体
     * @author daxiong
     * @date 2019-07-25 16:41
     * @param userId    被关注者id
     * @param followUserId  关注者id
     * @return void
     **/
    UsersFans getByUserIdAndFanId(Integer userId, Integer followUserId);
    /**
     * 取消关注
     * @author daxiong
     * @date 2019-07-25 17:03
     * @param userId
     * @param followUserId
     * @return void
     */
    void cancelFollow(Integer userId, Integer followUserId);

    /**
     * 保存
     * @author daxiong
     * @date 2019-07-25 17:17
     * @param usersFans
     * @return void
     **/
    void saveUsersFans(UsersFans usersFans);
}
