package com.leicx.xxz.mapper;

import com.leicx.xxz.entity.UsersFans;
import com.leicx.xxz.util.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersFansMapper extends IBaseMapper<UsersFans> {
    void insertSelective(UsersFans usersFans);

    UsersFans getByUserIdAndFanId(@Param("userId") Integer userId, @Param("fanId") Integer fanId);

    void updateSelective(UsersFans usersFans);
}