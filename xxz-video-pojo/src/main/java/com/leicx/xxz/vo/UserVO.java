package com.leicx.xxz.vo;

import com.leicx.xxz.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 返回给前端的用户vo
 */
@Getter
@Setter
public class UserVO {

    /**
     * 用户实体
     */
    private UserEntity userEntity;

    /**
     * 用户token
     */
    private String token;
}
