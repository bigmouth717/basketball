package com.maodami.basketball.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.maodami.basketball.entity.Card;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {
    //返回结果可能是多个，所以用List来装
    List<Card> findByUserId(Long userId);
}
