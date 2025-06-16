package com.event.config.app.api_event.mapper;


import com.event.config.app.api_event.dto.EventTourDto;
import com.event.config.app.api_event.dto.TourDto;
import com.event.config.app.api_event.model.Tour;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TourMapper {
    TourMapper INSTANCE = Mappers.getMapper(TourMapper.class);

    TourDto toDTO(Tour tour);

    Tour toEntity(TourDto tourDTO);
    
    default List<EventTourDto> toEventDTOs(List<Long> eventIds, List<EventTourDto> events) {
        if (eventIds == null || events == null) {
            return null;
        }

        Set<Long> idsSet = new HashSet<>(eventIds); // Para búsquedas rápidas

        return events.stream()
                .filter(e -> idsSet.contains(e.getIdEvent()))
                .collect(Collectors.toList());
    }

}
