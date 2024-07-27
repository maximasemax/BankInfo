package com.example.bankInfo.mapper;

import com.example.bankInfo.entity.Ed807Entity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.cbr.ed.v2.ED807;

@Mapper(uses = {BicDirectoryEntryTypeMapper.class},componentModel = "spring")
public interface Ed807Mapper {

    Ed807Mapper INSTANCE = Mappers.getMapper(Ed807Mapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bicDirectoryEntry", ignore = true)
    @Mapping(target = "edDate", ignore = true)
    @Mapping(target = "edNo", ignore = true)
    @Mapping(target = "edAuthor", ignore = true)
    Ed807Entity ed807ToEd807Entity(ED807 ed807);

//    @Mapping(target = "bICDirectoryEntry", ignore = true)
//    ED807 ed807EntityToED807(Ed807Entity ed807Entity);
}
