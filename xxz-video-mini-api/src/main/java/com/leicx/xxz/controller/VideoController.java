package com.leicx.xxz.controller;

import com.leicx.xxz.dto.video.VideoListDTO;
import com.leicx.xxz.dto.video.VideoUploadDTO;
import com.leicx.xxz.entity.Videos;
import com.leicx.xxz.enums.ErrorCodeEnum;
import com.leicx.xxz.service.VideoService;
import com.leicx.xxz.util.LcxJSONResult;
import com.leicx.xxz.vo.video.VideoListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户注册的controller
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 上传视频
     * @param userId    用户id
     * @param videoDesc 视频描述，可以为空
     * @param bgmId 背景音乐id，可以为空
     * @param videoSeconds  视频长度
     * @param videoWidth    视频宽度
     * @param videoHeight   视频高度
     * @param file  视频文件
     * @return
     */
    @PostMapping(value = "/upload")
    public LcxJSONResult uploadVideo(Integer userId, String videoDesc, Integer bgmId, Double videoSeconds,
            Integer videoWidth, Integer videoHeight, MultipartFile file) {

        // 参数校验
        if (userId == null || videoSeconds == null || file == null
                || videoWidth ==null || videoHeight == null) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_100002);
        }
        // 视频时长校验
        if (videoSeconds < 1 || videoSeconds >= 11) {
            return LcxJSONResult.errorException(ErrorCodeEnum.ERROR_CODE_300001);
        }

        VideoUploadDTO videoUploadDTO = new VideoUploadDTO();
        videoUploadDTO.setUserId(userId);
        videoUploadDTO.setVideoDesc(videoDesc);
        videoUploadDTO.setBgmId(bgmId);
        videoUploadDTO.setVideoSeconds(videoSeconds);
        videoUploadDTO.setVideoWidth(videoWidth);
        videoUploadDTO.setVideoHeight(videoHeight);
        videoUploadDTO.setFile(file);

        // 视频上传服务器，并保存到数据库中
        String dbPath = videoService.saveVideo(videoUploadDTO);
        return LcxJSONResult.ok(dbPath);
    }

    @PostMapping(value = "/list")
    public LcxJSONResult listVideo(@RequestBody VideoListDTO videoListDTO) {

        VideoListVO videoListVO = videoService.getVideoList(videoListDTO);
        return LcxJSONResult.ok(videoListVO);
    }
}
