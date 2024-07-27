package com.example.bankInfo.converter;

import com.example.bankInfo.entity.Ed807Entity;
import com.example.bankInfo.mapper.Ed807Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import ru.cbr.ed.v2.ED807;

@Component

public class Ed807Converter {

    private final Ed807Mapper ed807Mapper = Ed807Mapper.INSTANCE;

    public Ed807Entity ed807DtoToEntity(ED807 ed807) {
        return ed807Mapper.ed807ToEd807Entity(ed807);
    }



}
