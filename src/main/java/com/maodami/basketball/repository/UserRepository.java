package com.maodami.basketball.repository;

import com.maodami.basketball.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //返回结果只能是一个或者0个，所以用Optional来装
    Optional<User> findByOpenId(String openId);

    boolean existsByOpenId(String openId);
}
