package com.leicx.xxz.service.impl;

import com.leicx.xxz.entity.Bgm;
import com.leicx.xxz.mapper.BgmMapper;
import com.leicx.xxz.service.BgmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BgmServiceImpl implements BgmService {

    @Autowired
    private BgmMapper bgmMapper;

    @Override
    public void insertBgm(Bgm bgm) {
        Date now = new Date();
        bgm.setCreateTime(now);
        bgm.setUpdateTime(now);
        bgmMapper.insert(bgm);
    }

    @Override
    public void updateBgm(Bgm bgm) {

    }

    @Override
    public Bgm getBgmByNameLike(String name, int del) {
        return null;
    }

    @Override
    public Bgm getBgmById(Integer bgmId) {
        return bgmMapper.getBgmById(bgmId);
    }

    @Override
    public List<Bgm> list(Map<String, Object> param) {
        return bgmMapper.list(param);
    }
}
