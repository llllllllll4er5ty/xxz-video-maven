package com.leicx.xxz.mapper;

import com.leicx.xxz.entity.Bgm;
import com.leicx.xxz.util.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BgmMapper extends IBaseMapper<Bgm> {
    /**
     * 插入bgm实体
     * @param bgm
     */
    void insert(Bgm bgm);
    /**
     * 获取bgm实体列表
     * @param param
     */
    List<Bgm> list(@Param("param") Map<String, Object> param);
    /**
     * 根据主键获取bgm实体
     * @param id
     */
    Bgm getBgmById(@Param("id") Integer id);
}