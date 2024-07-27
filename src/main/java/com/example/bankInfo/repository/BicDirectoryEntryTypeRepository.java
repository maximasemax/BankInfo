package com.example.bankInfo.repository;

import com.example.bankInfo.entity.BICDirectoryEntryTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicDirectoryEntryTypeRepository extends JpaRepository<BICDirectoryEntryTypeEntity, Long> {
}
