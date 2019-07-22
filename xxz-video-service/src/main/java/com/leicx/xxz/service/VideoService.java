package com.leicx.xxz.service;

import com.leicx.xxz.dto.video.VideoListDTO;
import com.leicx.xxz.dto.video.VideoUploadDTO;
import com.leicx.xxz.entity.Videos;
import com.leicx.xxz.vo.video.VideoListVO;

import java.util.List;

public interface VideoService {

    /**
     * 插入视频
     * @param video 视频实体
     */
    void insertVideo(Videos video);
    /**
     * 更新视频
     * @param video 视频实体
     */
    void updateVideo(Videos video);

    /**
     * 根据视频名获取视频实体
     * @param name  视频名
     * @param del   删除标志，1：已删除，0：正常
     * @return 视频实体
     */
    Videos getVideoByName(String name, int del);
    /**
     * 根据视频id获取视频实体
     * @param videoId  视频id
     * @return 视频实体
     */
    Videos getVideoById(Integer videoId);

    /**
     * 获取视频列表
     * @param videoListDTO  条件dto
     * @return 视频实体
     */
    VideoListVO getVideoList(VideoListDTO videoListDTO);

    /**
     * 上传视频头像到服务器（本地）
     * @param videoUploadDTO    视频上传的DTO
     * @return string   视频在db中的存储路径
     */
    String saveVideo(VideoUploadDTO videoUploadDTO);
}
