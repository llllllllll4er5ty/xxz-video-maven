package com.leicx.entity;

import javax.persistence.Column;
import java.util.Date;

public class Bgm {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 上传者用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 背景音乐名称
     */
    private String name;

    /**
     * 音频地址
     */
    private String path;

    /**
     * 创建时间
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
     * 获取上传者用户id
     *
     * @return user_id - 上传者用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置上传者用户id
     *
     * @param userId 上传者用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取背景音乐名称
     *
     * @return name - 背景音乐名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置背景音乐名称
     *
     * @param name 背景音乐名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取音频地址
     *
     * @return path - 音频地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置音频地址
     *
     * @param path 音频地址
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
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