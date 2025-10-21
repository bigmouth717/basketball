package com.maodami.basketball.enums;

public enum CardStatus {
    ACTIVATED,    // 已激活 - 正常使用中
    EXPIRED,      // 已过期 - 超过有效期
    SUSPENDED,    // 已暂停 - 用户主动暂停或违规暂停
    CANCELLED,    // 已注销 - 用户主动注销
    PENDING       // 待激活 - 新卡未激活
}
