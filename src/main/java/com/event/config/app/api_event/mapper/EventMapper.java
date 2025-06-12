package com.event.config.app.api_event.mapper;

import java.util.stream.Collectors;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.event.config.app.api_event.dto.CreateEventDto;
import com.event.config.app.api_event.dto.EventResponseDto;
import com.event.config.app.api_event.dto.EventTimeResponseDto;
import com.event.config.app.api_event.dto.UpdateEventDto;
import com.event.config.app.api_event.model.Event;
import com.event.config.app.api_event.model.EventTime;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event toEntity(CreateEventDto dto);

    EventResponseDto toDto(Event entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Event target, UpdateEventDto source);

    @AfterMapping
    default void mapEventTimes(@MappingTarget EventResponseDto dto, Event event) {
        if (event.getEventTimes() != null) {
            dto.setEventTimes(event.getEventTimes().stream()
                .map(this::toEventTimeDto)
                .collect(Collectors.toList()));
        }
    }

    EventTimeResponseDto toEventTimeDto(EventTime eventTime);

}


