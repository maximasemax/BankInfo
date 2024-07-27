package com.example.bankInfo.mapper;

import com.example.bankInfo.entity.RstrListTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.cbr.ed.v2.RstrListType;

@Mapper(componentModel = "spring")
public interface RstrListTypeMapper {

    RstrListTypeMapper INSTANCE = Mappers.getMapper(RstrListTypeMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "participantInfoTypeEntity", ignore = true)
    RstrListTypeEntity rstrListTypeToEntity(RstrListType rstrListType);

}
