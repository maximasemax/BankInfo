package com.example.bankInfo.mapper;

import com.example.bankInfo.entity.ParticipantInfoTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.cbr.ed.v2.ParticipantInfoType;
@Mapper(componentModel = "spring")
public interface ParticipantInfoTypeMapper {

    ParticipantInfoTypeMapper INSTANCE = Mappers.getMapper(ParticipantInfoTypeMapper.class);

    @Mapping(source = "UID", target = "uid")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rstrListTypeEntity", ignore = true)
    ParticipantInfoTypeEntity participantInfoTypeToEntity(ParticipantInfoType participantInfoType);

}
