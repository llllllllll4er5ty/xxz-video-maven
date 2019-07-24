package com.leicx.xxz.vo.video;

import com.leicx.xxz.entity.Comments;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取评论列表的VO
 * @author daxiong
 * @date 2019-07-19 15:04
 **/
@Getter
@Setter
public class CommentListVO {

    private List<? extends Comments> commentsList;

    /**
     * 评论总数
     */
    private Long totalCount;

    /**
     * 页数总数
     */
    private Integer pageTotal;
}
