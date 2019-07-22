package com.leicx.xxz.entity.ext;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.entity.Videos;
import lombok.Getter;
import lombok.Setter;

/**
 * 视频列表的VO
 * @author daxiong
 * @date 2019-07-19 10:21
 **/
@Getter
@Setter
public class VideoExt extends Videos {
    private UserEntity userEntity;
}
