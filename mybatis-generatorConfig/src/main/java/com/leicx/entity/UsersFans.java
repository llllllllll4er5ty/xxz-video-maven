package com.leicx.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "users_fans")
public class UsersFans {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 粉丝id
     */
    @Column(name = "fan_id")
    private Integer fanId;

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
    private Byte del;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取粉丝id
     *
     * @return fan_id - 粉丝id
     */
    public Integer getFanId() {
        return fanId;
    }

    /**
     * 设置粉丝id
     *
     * @param fanId 粉丝id
     */
    public void setFanId(Integer fanId) {
        this.fanId = fanId;
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
    public Byte getDel() {
        return del;
    }

    /**
     * 设置删除标志，1：已删除；0：正常
     *
     * @param del 删除标志，1：已删除；0：正常
     */
    public void setDel(Byte del) {
        this.del = del;
    }
}