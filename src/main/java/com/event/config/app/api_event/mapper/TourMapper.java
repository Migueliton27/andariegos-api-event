package com.event.config.app.api_event.mapper;


import com.event.config.app.api_event.dto.TourDto;
import com.event.config.app.api_event.model.Tour;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TourMapper {
    TourMapper INSTANCE = Mappers.getMapper(TourMapper.class);

    TourDto toDTO(Tour tour);

    Tour toEntity(TourDto tourDTO);
}