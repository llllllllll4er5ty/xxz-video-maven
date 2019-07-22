package com.leicx.xxz.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 基础分页查询dto，封装前端传入的数据
 */
@Getter
@Setter
public class BasePageHelperDTO {
    /**
     * 开始页
     */
    private Integer start;
    /**
     * 查询条数
     */
    private Integer pageNum;
    /**
     * 排序字段
     */
    private String orderByStr;
}
