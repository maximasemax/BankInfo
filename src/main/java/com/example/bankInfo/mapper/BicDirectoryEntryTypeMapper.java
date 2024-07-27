package com.example.bankInfo.mapper;

import com.example.bankInfo.entity.BICDirectoryEntryTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.cbr.ed.v2.BICDirectoryEntryType;

@Mapper(componentModel = "spring")
public interface BicDirectoryEntryTypeMapper {

    BicDirectoryEntryTypeMapper INSTANCE = Mappers.getMapper(BicDirectoryEntryTypeMapper.class);

    @Mapping(source = "BIC", target = "bic")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ed807EntityId", ignore = true)
    @Mapping(target = "swbics", ignore = true)
    @Mapping(target = "accounts", ignore = true)
    @Mapping(target = "participantInfo", ignore = true)
    BICDirectoryEntryTypeEntity bicDirectoryEntryTypeToEntity(BICDirectoryEntryType bicDirectoryEntryType);

}
