package com.leicx.xxz.service;

import com.leicx.xxz.dto.comment.CommentListDTO;
import com.leicx.xxz.entity.Comments;
import com.leicx.xxz.entity.Videos;
import com.leicx.xxz.vo.video.CommentListVO;

public interface CommentService {

    /**
     * 插入评论
     * @param comments 评论实体
     */
    void insertComment(Comments comments);
    /**
     * 更新评论
     * @param comments 评论实体
     */
    void updateComment(Comments comments);

    /**
     * 根据评论id获取评论实体
     * @param commentId  评论id
     * @return 评论实体
     */
    Videos getCommentById(Integer commentId);

    /**
     * 获取评论列表
     * @param commentListDTO  条件dto
     * @return 评论实体
     */
    CommentListVO getCommentsList(CommentListDTO commentListDTO);

    /**
     * 保存评论
     * @param comments 评论实体
     * @return string   评论在db中的存储路径
     */
    void saveComment(Comments comments);
}
