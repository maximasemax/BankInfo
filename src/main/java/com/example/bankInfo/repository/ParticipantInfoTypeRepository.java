package com.example.bankInfo.repository;

import com.example.bankInfo.entity.Ed807Entity;
import com.example.bankInfo.entity.ParticipantInfoTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.cbr.ed.v2.ParticipantInfoType;

public interface ParticipantInfoTypeRepository extends JpaRepository<ParticipantInfoTypeEntity, Long> {
}
