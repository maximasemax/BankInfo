package com.example.bankInfo.mapper;

import com.example.bankInfo.entity.AccountsTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.cbr.ed.v2.AccountsType;

@Mapper(uses = {AccRstrListMapper.class},componentModel = "spring" )
public interface AccountsTypeMapper {

    AccountsTypeMapper INSTANCE = Mappers.getMapper(AccountsTypeMapper.class);

    @Mapping(source = "CK", target = "ck")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accRstrList", ignore = true)
    @Mapping(target = "bicDirectoryEntryTypeEntity", ignore = true)
    AccountsTypeEntity accountsTypeToEntity(AccountsType accountsType);
}
