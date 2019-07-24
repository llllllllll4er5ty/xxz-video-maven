package com.leicx.xxz.dto.comment;

import com.leicx.xxz.dto.BasePageHelperDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * 获取视频列表的dto
 * @author daxiong
 * @date 2019-07-18 14:24
 **/
@Getter
@Setter
public class CommentListDTO extends BasePageHelperDTO {
    /**
     * 视频id
     */
    private Integer videoId;
}
