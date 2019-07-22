package com.leicx.xxz.mapper;

import com.leicx.xxz.entity.Videos;
import com.leicx.xxz.util.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VideosMapper extends IBaseMapper<Videos> {
    /**
     * 插入视频实体
     * @param videos
     */
    void insert(Videos videos);
    /**
     * 插入视频实体，如果有属性则替换，没有属性则不替换
     * @param videos
     */
    void insertSelective(Videos videos);
    /**
     * 获取bgm实体列表
     * @param param
     */
    List<Videos> list(@Param("param") Map<String, Object> param);
}