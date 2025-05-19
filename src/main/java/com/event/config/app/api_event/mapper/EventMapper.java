package com.event.config.app.api_event.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.event.config.app.api_event.dto.CreateEventDto;
import com.event.config.app.api_event.dto.UpdateEventDto;
import com.event.config.app.api_event.model.Event;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event toEntity(CreateEventDto dto);

    CreateEventDto toDto(Event entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Event target, UpdateEventDto source);
}
