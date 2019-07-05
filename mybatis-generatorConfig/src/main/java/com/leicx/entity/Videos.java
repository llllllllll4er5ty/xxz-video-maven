package com.leicx.entity;

import javax.persistence.Column;
import java.util.Date;

public class Videos {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 发布者用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 音频id，默认为null
     */
    @Column(name = "audio_id")
    private Integer audioId;

    /**
     * video描述
     */
    @Column(name = "video_desc")
    private String videoDesc;

    /**
     * video地址
     */
    @Column(name = "video_path")
    private String videoPath;

    /**
     * video时长
     */
    @Column(name = "video_seconds")
    private Float videoSeconds;

    /**
     * video宽度
     */
    @Column(name = "video_width")
    private Integer videoWidth;

    /**
     * video高度
     */
    @Column(name = "video_height")
    private Integer videoHeight;

    /**
     * video封面地址
     */
    @Column(name = "cover_path")
    private String coverPath;

    /**
     * 点赞数
     */
    @Column(name = "like_counts")
    private Long likeCounts;

    /**
     * 视频状态，(默认)1：正常，2：禁播，3：审核中
     */
    private Boolean status;

    /**
     * 创建时间，即关注时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标志，1：已删除；0：正常
     */
    private Boolean del;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取发布者用户id
     *
     * @return user_id - 发布者用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置发布者用户id
     *
     * @param userId 发布者用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取音频id，默认为null
     *
     * @return audio_id - 音频id，默认为null
     */
    public Integer getAudioId() {
        return audioId;
    }

    /**
     * 设置音频id，默认为null
     *
     * @param audioId 音频id，默认为null
     */
    public void setAudioId(Integer audioId) {
        this.audioId = audioId;
    }

    /**
     * 获取video描述
     *
     * @return video_desc - video描述
     */
    public String getVideoDesc() {
        return videoDesc;
    }

    /**
     * 设置video描述
     *
     * @param videoDesc video描述
     */
    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    /**
     * 获取video地址
     *
     * @return video_path - video地址
     */
    public String getVideoPath() {
        return videoPath;
    }

    /**
     * 设置video地址
     *
     * @param videoPath video地址
     */
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    /**
     * 获取video时长
     *
     * @return video_seconds - video时长
     */
    public Float getVideoSeconds() {
        return videoSeconds;
    }

    /**
     * 设置video时长
     *
     * @param videoSeconds video时长
     */
    public void setVideoSeconds(Float videoSeconds) {
        this.videoSeconds = videoSeconds;
    }

    /**
     * 获取video宽度
     *
     * @return video_width - video宽度
     */
    public Integer getVideoWidth() {
        return videoWidth;
    }

    /**
     * 设置video宽度
     *
     * @param videoWidth video宽度
     */
    public void setVideoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
    }

    /**
     * 获取video高度
     *
     * @return video_height - video高度
     */
    public Integer getVideoHeight() {
        return videoHeight;
    }

    /**
     * 设置video高度
     *
     * @param videoHeight video高度
     */
    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    /**
     * 获取video封面地址
     *
     * @return cover_path - video封面地址
     */
    public String getCoverPath() {
        return coverPath;
    }

    /**
     * 设置video封面地址
     *
     * @param coverPath video封面地址
     */
    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    /**
     * 获取点赞数
     *
     * @return like_counts - 点赞数
     */
    public Long getLikeCounts() {
        return likeCounts;
    }

    /**
     * 设置点赞数
     *
     * @param likeCounts 点赞数
     */
    public void setLikeCounts(Long likeCounts) {
        this.likeCounts = likeCounts;
    }

    /**
     * 获取视频状态，(默认)1：正常，2：禁播，3：审核中
     *
     * @return status - 视频状态，(默认)1：正常，2：禁播，3：审核中
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置视频状态，(默认)1：正常，2：禁播，3：审核中
     *
     * @param status 视频状态，(默认)1：正常，2：禁播，3：审核中
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取创建时间，即关注时间
     *
     * @return create_time - 创建时间，即关注时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间，即关注时间
     *
     * @param createTime 创建时间，即关注时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取删除标志，1：已删除；0：正常
     *
     * @return del - 删除标志，1：已删除；0：正常
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * 设置删除标志，1：已删除；0：正常
     *
     * @param del 删除标志，1：已删除；0：正常
     */
    public void setDel(Boolean del) {
        this.del = del;
    }
}