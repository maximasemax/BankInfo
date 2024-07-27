package com.example.bankInfo.repository;


import com.example.bankInfo.entity.Ed807Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Ed807Repository extends JpaRepository<Ed807Entity, Long> {

    @Override
    Optional<Ed807Entity> findById(Long aLong);
}
