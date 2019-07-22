package com.leicx.xxz.dto.video;

import com.leicx.xxz.dto.BasePageHelperDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 获取视频列表的dto
 * @author daxiong
 * @date 2019-07-18 14:24
 **/
@Getter
@Setter
public class VideoListDTO extends BasePageHelperDTO {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 根据名称模糊搜索
     */
    private String nameLike;

    /**
     * 排序类型
     */
    private String orderType;

    /**
     * 排序字段
     */
    private String orderStr;

    /**
     * 视频状态
     */
    private Integer status;
}
