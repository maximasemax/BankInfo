package com.example.bankInfo.repository;

import com.example.bankInfo.entity.Ed807Entity;
import com.example.bankInfo.entity.SwBicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwBicsRepository extends JpaRepository<SwBicsEntity, Long> {
}
