package com.leicx.xxz.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

public class Users {
    /**
     * 主键
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 微信号
     */
    private String wxid;

    /**
     * 用户积分
     */
    private Long points;

    /**
     * 用户个人介绍
     */
    private String desc;

    /**
     * 用户状态，1：正常用户，2：vip用户，3：拉黑用户
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
     * 获取用户姓名
     *
     * @return name - 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     *
     * @param name 用户姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户年龄
     *
     * @return age - 用户年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置用户年龄
     *
     * @param age 用户年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取用户头像
     *
     * @return avatar - 用户头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置用户头像
     *
     * @param avatar 用户头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取微信号
     *
     * @return wxid - 微信号
     */
    public String getWxid() {
        return wxid;
    }

    /**
     * 设置微信号
     *
     * @param wxid 微信号
     */
    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    /**
     * 获取用户积分
     *
     * @return points - 用户积分
     */
    public Long getPoints() {
        return points;
    }

    /**
     * 设置用户积分
     *
     * @param points 用户积分
     */
    public void setPoints(Long points) {
        this.points = points;
    }

    /**
     * 获取用户个人介绍
     *
     * @return desc - 用户个人介绍
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置用户个人介绍
     *
     * @param desc 用户个人介绍
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取用户状态，1：正常用户，2：vip用户，3：拉黑用户
     *
     * @return status - 用户状态，1：正常用户，2：vip用户，3：拉黑用户
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置用户状态，1：正常用户，2：vip用户，3：拉黑用户
     *
     * @param status 用户状态，1：正常用户，2：vip用户，3：拉黑用户
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