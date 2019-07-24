package com.leicx.xxz.entity.ext;

import com.leicx.xxz.entity.Comments;
import com.leicx.xxz.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentExt extends Comments {
    private UserEntity userEntity;
    /**
     * 被评论用户
     */
    private UserEntity toUserEntity;

    /**
     * 评论时间的字符串显示
     */
    private String timeAgoStr;
}
