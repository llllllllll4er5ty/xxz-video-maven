package com.leicx.xxz.mapper;

import com.leicx.xxz.entity.Comments;
import com.leicx.xxz.util.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentsMapper extends IBaseMapper<Comments> {
    void insertSelective(Comments comments);

    List<Comments> getCommentsList(@Param("param") Map<String, Object> param);
}