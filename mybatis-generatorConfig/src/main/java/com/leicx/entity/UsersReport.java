package com.leicx.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "users_report")
public class UsersReport {
    /**
     * 主键
     */
    private Integer id;

    /**
     * (举报者)用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 视频id
     */
    @Column(name = "video_id")
    private Integer videoId;

    /**
     * 举报类型,详见枚举
     */
    @Column(name = "report_type")
    private Integer reportType;

    /**
     * 举报内容
     */
    @Column(name = "report_desc")
    private String reportDesc;

    /**
     * 创建时间，即点赞时间
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
     * 获取(举报者)用户id
     *
     * @return user_id - (举报者)用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置(举报者)用户id
     *
     * @param userId (举报者)用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取视频id
     *
     * @return video_id - 视频id
     */
    public Integer getVideoId() {
        return videoId;
    }

    /**
     * 设置视频id
     *
     * @param videoId 视频id
     */
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    /**
     * 获取举报类型,详见枚举
     *
     * @return report_type - 举报类型,详见枚举
     */
    public Integer getReportType() {
        return reportType;
    }

    /**
     * 设置举报类型,详见枚举
     *
     * @param reportType 举报类型,详见枚举
     */
    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    /**
     * 获取举报内容
     *
     * @return report_desc - 举报内容
     */
    public String getReportDesc() {
        return reportDesc;
    }

    /**
     * 设置举报内容
     *
     * @param reportDesc 举报内容
     */
    public void setReportDesc(String reportDesc) {
        this.reportDesc = reportDesc;
    }

    /**
     * 获取创建时间，即点赞时间
     *
     * @return create_time - 创建时间，即点赞时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间，即点赞时间
     *
     * @param createTime 创建时间，即点赞时间
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