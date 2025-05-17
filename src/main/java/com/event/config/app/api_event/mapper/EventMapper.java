package com.event.config.app.api_event.mapper;

import org.springframework.stereotype.Component;

import com.event.config.app.api_event.dto.CreateEventDto;
import com.event.config.app.api_event.model.Event;

@Component
public class EventMapper {
    public Event toEntity(CreateEventDto createEventDto) {
        Event event = new Event();
        event.setName(createEventDto.getName());
        event.setDescription(createEventDto.getDescription());
        event.setDate(createEventDto.getDate());
        event.setCity(createEventDto.getCity());
        event.setAddress(createEventDto.getAddress());
        event.setAvailableSpots(createEventDto.getAvailableSpots());
        event.setPrice(createEventDto.getPrice());
        event.setImage1(createEventDto.getImage1());
        event.setImage2(createEventDto.getImage2());
        event.setImage3(createEventDto.getImage3());

        return event;
    }

    public CreateEventDto toDto(Event event) {
        CreateEventDto createEventDto = new CreateEventDto();
        createEventDto.setName(event.getName());
        createEventDto.setDescription(event.getDescription());
        createEventDto.setDate(event.getDate());
        createEventDto.setCity(event.getCity());
        createEventDto.setAddress(event.getAddress());
        createEventDto.setAvailableSpots(event.getAvailableSpots());
        createEventDto.setPrice(event.getPrice());
        createEventDto.setImage1(event.getImage1());
        createEventDto.setImage2(event.getImage2());
        createEventDto.setImage3(event.getImage3());

        return createEventDto;
    }
}
