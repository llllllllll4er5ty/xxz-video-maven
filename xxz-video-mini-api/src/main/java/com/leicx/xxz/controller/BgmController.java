package com.leicx.xxz.controller;

import com.leicx.xxz.constant.ParamConstant;
import com.leicx.xxz.constant.SysConstant;
import com.leicx.xxz.dto.BgmDTO;
import com.leicx.xxz.entity.Bgm;
import com.leicx.xxz.service.BgmService;
import com.leicx.xxz.util.LcxJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/bgm")
public class BgmController {

    @Autowired
    private BgmService bgmService;

    /**
     * 获取bgm实体列表
     * @param bgmDTO
     * @return
     */
    @RequestMapping("/list")
    public LcxJSONResult list(@RequestBody BgmDTO bgmDTO) {
        Integer start = bgmDTO.getStart();
        Integer pageNum = bgmDTO.getPageNum();
        String orderByStr = bgmDTO.getOrderByStr();
        // 设置默认值
        start = start == null ? 0 : start;
        pageNum = pageNum == null ? 10 : pageNum;

        // 封装查询条件
        Map<String, Object> param = new HashMap<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        param.put(ParamConstant.START, start);
        param.put(ParamConstant.PAGE_NUM, pageNum);
        param.put(ParamConstant.ORDER_BY_STR, orderByStr);
        param.put(ParamConstant.DEL, 0);
        List<Bgm> bgmList = bgmService.list(param);
        return LcxJSONResult.ok(bgmList);
    }
}
