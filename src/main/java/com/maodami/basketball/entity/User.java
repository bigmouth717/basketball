package com.maodami.basketball.entity;

import com.maodami.basketball.enums.UserRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //微信账户绑定认证
    @Column(unique = true, nullable = false)
    private String openId;

    //业务字段
    private String nickname;

    @Column(nullable = false)
    private String avatar;

    private String phone;

    //定义用户类型的枚举字段
    //@Enumerated(EnumType.STRING) = "把Java枚举以字符串的形式存放在数据库"
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    //创建时间
    @Column(nullable = false)
    private LocalDateTime createTime = LocalDateTime.now();

    //更新时间
    private LocalDateTime updateTime = LocalDateTime.now();

    //JPA自动处理更新时间
    @PreUpdate
    public void preUpdate() {
        this.updateTime = LocalDateTime.now();
    }

    //无参构造方法
    protected User() {
        //在JPA Entity中，建议显式写出无参构造方法JPA 规范推荐：protected 无参构造方法，防止业务代码直接调用，但框架反射可以访问
    }

    //有参数的构造方法，赋值的字段只需要包含必填的字段
    public User(String openId, String avatar, UserRole role) {
        this.openId = openId;//必填
//        this.nickname = nickname;//不必填
        this.avatar = avatar;//必填
//        this.phone = phone;//不必填
        this.role = role;//必填
    }

    //getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
