package com.event.config.app.api_event.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.event.config.app.api_event.dto.AvailabilityPatternDto;
import com.event.config.app.api_event.model.AvailabilityPattern;

@Mapper(componentModel = "spring")
public interface AvailabilityPatternMapper {
    
    AvailabilityPatternMapper INSTANCE = Mappers.getMapper(AvailabilityPatternMapper.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eventTimes", ignore = true)
    AvailabilityPattern toEntity(AvailabilityPatternDto dto);
}
