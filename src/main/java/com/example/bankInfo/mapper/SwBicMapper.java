package com.example.bankInfo.mapper;

import com.example.bankInfo.entity.SwBicsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.cbr.ed.v2.SWBICList;

@Mapper(componentModel = "spring")
public interface SwBicMapper {

    SwBicMapper INSTANCE = Mappers.getMapper(SwBicMapper.class);

    @Mapping(source = "SWBIC", target = "swbic")
    @Mapping(source = "defaultSWBIC", target = "defaultSwBic")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bicDirectoryEntryTypeEntity", ignore = true)
    SwBicsEntity swBicToEntity(SWBICList swbicList);
}
