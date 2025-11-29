package com.maodami.basketball.service.impl;

import com.maodami.basketball.dto.response.WechatLoginResponse;
import com.maodami.basketball.entity.User;
import com.maodami.basketball.repository.UserRepository;
import com.maodami.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    //RestClient 是 Spring Boot 3.2+ 引入的一个HTTP 客户端工具,用于在服务层调用外部的 REST API。
    private final RestClient restClient;

    //通过构造方法注入UserRepository和RestClient
    public UserServiceImpl(UserRepository userRepository, RestClient restClient) {
        this.userRepository = userRepository;
        this.restClient = restClient;
    }

    //作用： 微信小程序的唯一标识符
    @Value("${wechat.app-id}")
    private String appId;
    //作用： 微信小程序的密钥，用于服务器端 API 调用认证
    @Value("${wechat.app-secret}")
    private String appSecret;
    //微信登录 API
    @Value("${wechat.login-url}")
    private String appLoginUri;

    //通过微信账户登录
    @Override
    public User wechatLogin(String code, String nickName, String avatarUrl) {
        //构造微信登录接口的完整URL，包含了必要的参数
        String url = UriComponentsBuilder
                .fromUriString(appLoginUri)//微信接口地址
                .queryParam("appid", appId)//来自小程序ID
                .queryParam("secret", appSecret)//来自小程序密钥
                .queryParam("js_code", code)//code来自用户
                .queryParam("grant_type", "authorization_code")
                .toUriString();

        //使用 RestClient 发送 HTTP GET 请求到微信服务器
        //.get是设置http的方法为get
        //.url是设置请求的URL
        //.retrieve 进入响应处理阶段
        //.body 将响应的JSON内容体自动转换为WechatLoginResponse类的java对象response
        WechatLoginResponse response = restClient.get().uri(url).retrieve().body(WechatLoginResponse.class);
        return null;
    }
}
