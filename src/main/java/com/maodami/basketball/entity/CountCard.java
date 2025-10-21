package com.maodami.basketball.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "count_card")
public class CountCard extends Card {
    //次卡业务字段
    private Integer totalCount = 0;
    private Integer remainCount = 0;

    // 无参构造方法（JPA要求）
    protected CountCard() {
    }

    // 带参数的构造方法（可选）
    public CountCard(Integer totalCount) {
        this.totalCount = totalCount;
        this.remainCount = totalCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Integer remainCount) {
        this.remainCount = remainCount;
    }
}
