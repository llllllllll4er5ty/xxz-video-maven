package com.leicx.entity;

import javax.persistence.Table;

@Table(name = "search_records")
public class SearchRecords {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 内容
     */
    private Integer content;

    /**
     * 搜索次数
     */
    private Integer counts;

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
     * 获取内容
     *
     * @return content - 内容
     */
    public Integer getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(Integer content) {
        this.content = content;
    }

    /**
     * 获取搜索次数
     *
     * @return counts - 搜索次数
     */
    public Integer getCounts() {
        return counts;
    }

    /**
     * 设置搜索次数
     *
     * @param counts 搜索次数
     */
    public void setCounts(Integer counts) {
        this.counts = counts;
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