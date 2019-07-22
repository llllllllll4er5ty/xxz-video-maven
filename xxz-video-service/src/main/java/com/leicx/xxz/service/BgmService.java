package com.leicx.xxz.service;

import com.leicx.xxz.entity.Bgm;

import java.util.List;
import java.util.Map;

public interface BgmService {

    /**
     * 插入背景音乐
     * @param Bgm 背景音乐实体
     */
    void insertBgm(Bgm Bgm);
    /**
     * 更新背景音乐
     * @param Bgm 背景音乐实体
     */
    void updateBgm(Bgm Bgm);

    /**
     * 根据背景音乐名获取背景音乐实体
     * @param name  背景音乐名
     * @param del   删除标志，1：已删除，0：正常
     * @return 背景音乐实体
     */
    Bgm getBgmByNameLike(String name, int del);
    /**
     * 根据背景音乐id获取背景音乐实体
     * @param BgmId  背景音乐id
     * @return 背景音乐实体
     */
    Bgm getBgmById(Integer BgmId);  
    /**
     * 获取bgm实体列表
     * @param param  参数集合
     * @return 背景音乐实体列表
     */
    List<Bgm> list(Map<String, Object> param);
}
