package com.leicx.xxz.dto.video;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * 上传视频的DTO
 */
@Getter
@Setter
public class VideoUploadDTO {
    /**
     * 视频上传者id
     */
    @NotNull(message = "用户id不能为空")
    private Integer userId;

    /**
     * 要上传的文件
     */
    private MultipartFile file;

    /**
     * 上传文件的地址
     */
    @NotNull(message = "上传文件地址不能为空")
    private String filePath;

    /**
     * 要上传的文件的大小
     */
    @NotNull(message = "上传文件大小不能为空")
    private Integer videoSize;

    /**
     * 上传文件的描述
     */
    private String videoDesc;

    /**
     * 上传文件的bgmId
     */
    private Integer bgmId;

    /**
     * 上传文件的时长
     */
    @NotNull(message = "上传文件时长不能为空")
    private Double videoSeconds;

    /**
     * 上传文件的宽度
     */
    @NotNull(message = "上传文件宽度不能为空")
    private Integer videoWidth;

    /**
     * 上传文件的高度
     */
    @NotNull(message = "上传文件高度不能为空")
    private Integer videoHeight;
}
