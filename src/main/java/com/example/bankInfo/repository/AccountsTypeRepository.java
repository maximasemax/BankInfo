package com.example.bankInfo.repository;

import com.example.bankInfo.entity.AccountsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsTypeRepository extends JpaRepository<AccountsTypeEntity, Long> {
}
