package com.maodami.basketball.service;

import com.maodami.basketball.entity.User;

public interface UserService {
    //通过微信账户登录
    User wechatLogin(String code, String nickName, String avatarUrl);
}
