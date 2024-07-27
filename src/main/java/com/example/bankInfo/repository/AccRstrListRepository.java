package com.example.bankInfo.repository;

import com.example.bankInfo.entity.AccRstrListEntity;
import com.example.bankInfo.entity.Ed807Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccRstrListRepository extends JpaRepository<AccRstrListEntity, Long> {
}
