package com.maodami.basketball.repository;

import com.maodami.basketball.entity.CardRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRecordRepository extends JpaRepository<CardRecord, Long> {
}
