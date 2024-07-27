package com.example.bankInfo.mapper;

import com.example.bankInfo.entity.AccRstrListEntity;
import com.example.bankInfo.entity.AccountsTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.cbr.ed.v2.AccRstrListType;
import ru.cbr.ed.v2.AccountsType;

@Mapper(componentModel = "spring")
public interface AccRstrListMapper {

    AccRstrListMapper INSTANCE = Mappers.getMapper(AccRstrListMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountsType", ignore = true)
    AccRstrListEntity AccRstrListToEntity(AccRstrListType accRstrListType);
}
