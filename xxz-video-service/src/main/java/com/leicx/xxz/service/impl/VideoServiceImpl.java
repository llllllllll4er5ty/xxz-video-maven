package com.leicx.xxz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leicx.xxz.constant.SysConstant;
import com.leicx.xxz.dto.video.VideoListDTO;
import com.leicx.xxz.dto.video.VideoUploadDTO;
import com.leicx.xxz.entity.Bgm;
import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.entity.Videos;
import com.leicx.xxz.entity.ext.VideoExt;
import com.leicx.xxz.enums.VideoStatusEnum;
import com.leicx.xxz.mapper.VideosMapper;
import com.leicx.xxz.service.BgmService;
import com.leicx.xxz.service.UserService;
import com.leicx.xxz.service.VideoService;
import com.leicx.xxz.util.FfmpegUtil;
import com.leicx.xxz.util.MapUtil;
import com.leicx.xxz.util.StringUtils;
import com.leicx.xxz.vo.video.VideoListVO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideosMapper videosMapper;
    @Autowired
    private BgmService bgmService;
    @Autowired
    private UserService userService;

    @Override
    public void insertVideo(Videos video) {
        Date now = new Date();
        video.setCreateTime(now);
        video.setUpdateTime(now);
        videosMapper.insert(video);
    }

    @Override
    public void updateVideo(Videos video) {

    }

    @Override
    public Videos getVideoByName(String name, int del) {
        return null;
    }

    @Override
    public Videos getVideoById(Integer videoId) {
        return null;
    }

    @Override
    public VideoListVO getVideoList(VideoListDTO videoListDTO) {
        // 获取参数
        Integer userId = videoListDTO.getUserId();
        Integer status = videoListDTO.getStatus();
        String orderStr = videoListDTO.getOrderStr();
        String orderType = videoListDTO.getOrderType();
        Integer start = videoListDTO.getStart();
        start = start == null ? 1 : start;
        Integer pageNum = videoListDTO.getPageNum();
        pageNum = pageNum == null ? 5 : pageNum;

        Map<String, Object> params = new HashMap<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        String orderByStr = null;
        if (StringUtils.isNotEmpty(orderStr) && StringUtils.isNotEmpty(orderType)) {
            orderByStr = orderStr + orderType;
        }
        MapUtil.addToMap(params, "orderByStr", orderByStr, "update_time desc");
        MapUtil.addToMap(params, "userId", userId);
        MapUtil.addToMap(params, "status", status, VideoStatusEnum.NORMAL.getCode());
        params.put("del", 0);
        // 分页
        PageHelper.startPage(start, pageNum);
        List<Videos> videosList = videosMapper.list(params);
        PageInfo<Videos> pageInfo = new PageInfo<>(videosList);

        VideoListVO videoListVO = new VideoListVO();
        // 视频列表为空，直接返回
        if (videosList.size() == 0) {
            videoListVO.setVideoList(videosList);
            return videoListVO;
        }

        // 获取视频相关的用户
        Set<Integer> userIdIn = new HashSet<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        videosList.forEach(item -> userIdIn.add(item.getUserId()));

        Map<String, Object> userParams = new HashMap<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        userParams.put("idIn", userIdIn);
        List<UserEntity> userList = userService.getUserList(userParams);

        // 拼装返回
        ArrayList<VideoExt> result = new ArrayList<>();
        Map<Integer, UserEntity> userMap = new HashMap<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        userList.forEach(item -> userMap.put(item.getId(), item));
        for (Videos video : videosList) {
            VideoExt videoExt = new VideoExt();
            BeanUtils.copyProperties(video, videoExt);
            Integer uId = video.getUserId();
            if (userMap.containsKey(uId)) {
                videoExt.setUserEntity(userMap.get(uId));
            }
            result.add(videoExt);
        }

        videoListVO.setVideoList(result);
        videoListVO.setPageTotal(pageInfo.getPages());
        videoListVO.setTotalCount(pageInfo.getTotal());
        return videoListVO;
    }

    @Override
    public String saveVideo(VideoUploadDTO videoUploadDTO) {
        Integer userId = videoUploadDTO.getUserId();
        MultipartFile videoFile = videoUploadDTO.getFile();
        Integer videoSize = videoUploadDTO.getVideoSize();

        Videos videos = new Videos();
        BeanUtils.copyProperties(videoUploadDTO, videos);

        // 本地文件路径前缀
        String filePathPrefix = null;
        // 判断是否有bgm，如果有则先存入临时目录，如果没有直接存入正式目录
        // ffmpeg无法直接就地修改源视频文件
        Integer bgmId = videoUploadDTO.getBgmId();
        if (bgmId == null) {
            filePathPrefix = SysConstant.STATIC_PATH_REFIX;
        } else {
            filePathPrefix = SysConstant.TEMP_VIDEO_PATH_REFIX;
        }

        // 数据库保存的文件路径前缀
        String fileDbPathPrefix = "/video/" + userId + "/";

        OutputStream outputStream = null;
        InputStream inputStream = null;

        try {
            String fileName = videoFile.getOriginalFilename();
            // 最终文件DB路径
            fileDbPathPrefix += fileName;
            // 最终文件路径
            String finalFilePath = filePathPrefix + fileDbPathPrefix;
            File file = new File(finalFilePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            outputStream = new FileOutputStream(finalFilePath);
            inputStream = videoFile.getInputStream();
            IOUtils.copy(inputStream, outputStream);

            // 如果有背景音乐，则替换bgm
            if (bgmId != null) {
                // 根据id获取bgm
                Bgm bgm = bgmService.getBgmById(bgmId);
                String relativeBgmPath = bgm.getPath();
                // bgm的绝对路径
                String absoluteBgmPath = SysConstant.STATIC_PATH_REFIX + relativeBgmPath;

                String tempVideoPath = finalFilePath;
                finalFilePath = SysConstant.STATIC_PATH_REFIX + fileDbPathPrefix;
                // 替换bgm，将视频存入正式目录
                FfmpegUtil.changeVideoBgm(tempVideoPath, absoluteBgmPath, finalFilePath, videos.getVideoSeconds());
                // 删除临时目录中的文件
                file.delete();
            }

            // 设置封面，将视频后缀改为.jpg，位置和视频在同一个目录下
            String coverPicturePath4Jpg = StringUtils.getCoverPicturePath4Jpg(fileDbPathPrefix);
            FfmpegUtil.getCoverPicture(finalFilePath, SysConstant.STATIC_PATH_REFIX + coverPicturePath4Jpg);

            // 保存到数据库
            videos.setVideoPath(fileDbPathPrefix);
            videos.setCoverPath(coverPicturePath4Jpg);
            insertVideo(videos);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileDbPathPrefix;
    }
}
