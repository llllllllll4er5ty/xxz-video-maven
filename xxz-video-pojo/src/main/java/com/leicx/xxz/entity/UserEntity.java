package com.leicx.xxz.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

public class UserEntity {
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
     * 用户密码
     */
    private String password;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户粉丝数
     */
    @Column(name = "fans_counts")
    private Long fansCounts;

    /**
     * 我关注的用户数
     */
    @Column(name = "follows_counts")
    private Long followsCounts;

    /**
     * 获赞数量
     */
    @Column(name = "receive_like_counts")
    private Long receiveLikeCounts;

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
    private String description;

    /**
     * 用户状态，1：正常用户，2：vip用户，3：拉黑用户
     */
    private int status;

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
    private int del;

    public UserEntity() {
        this.age = 0;
        this.avatar = "";
        this.fansCounts = 0L;
        this.followsCounts = 0L;
        this.receiveLikeCounts = 0L;
        this.wxid = "";
        this.points = 0L;
        this.description = "";
        this.status = 1;
        this.del = 0;
    }


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
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
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
     * 获取用户粉丝数
     *
     * @return fans_counts - 用户粉丝数
     */
    public Long getFansCounts() {
        return fansCounts;
    }

    /**
     * 设置用户粉丝数
     *
     * @param fansCounts 用户粉丝数
     */
    public void setFansCounts(Long fansCounts) {
        this.fansCounts = fansCounts;
    }

    /**
     * 获取我关注的用户数
     *
     * @return follows_counts - 我关注的用户数
     */
    public Long getFollowsCounts() {
        return followsCounts;
    }

    /**
     * 设置我关注的用户数
     *
     * @param followsCounts 我关注的用户数
     */
    public void setFollowsCounts(Long followsCounts) {
        this.followsCounts = followsCounts;
    }

    /**
     * 获取获赞数量
     *
     * @return receive_like_counts - 获赞数量
     */
    public Long getReceiveLikeCounts() {
        return receiveLikeCounts;
    }

    /**
     * 设置获赞数量
     *
     * @param receiveLikeCounts 获赞数量
     */
    public void setReceiveLikeCounts(Long receiveLikeCounts) {
        this.receiveLikeCounts = receiveLikeCounts;
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
     * @return description - 用户个人介绍
     */
    public String getDesc() {
        return description;
    }

    /**
     * 设置用户个人介绍
     *
     * @param description 用户个人介绍
     */
    public void setDesc(String description) {
        this.description = description;
    }

    /**
     * 获取用户状态，1：正常用户，2：vip用户，3：拉黑用户
     *
     * @return status - 用户状态，1：正常用户，2：vip用户，3：拉黑用户
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置用户状态，1：正常用户，2：vip用户，3：拉黑用户
     *
     * @param status 用户状态，1：正常用户，2：vip用户，3：拉黑用户
     */
    public void setStatus(int status) {
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
    public int getDel() {
        return del;
    }

    /**
     * 设置删除标志，1：已删除；0：正常
     *
     * @param del 删除标志，1：已删除；0：正常
     */
    public void setDel(int del) {
        this.del = del;
    }
}