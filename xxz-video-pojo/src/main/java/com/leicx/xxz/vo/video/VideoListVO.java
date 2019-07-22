package com.leicx.xxz.vo.video;

import com.leicx.xxz.entity.Videos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取视频列表的VO
 * @author daxiong
 * @date 2019-07-19 15:04
 **/
@Getter
@Setter
public class VideoListVO {

    private List<? extends Videos> videoList;

    /**
     * 视频总数
     */
    private Long totalCount;

    /**
     * 页数总数
     */
    private Integer pageTotal;
}
