package com.event.config.app.api_event.mapper;

import com.event.config.app.api_event.dto.PlanTourDto;
import com.event.config.app.api_event.model.PlanTour;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanTourMapper {
    PlanTourMapper INSTANCE = Mappers.getMapper(PlanTourMapper.class);

    PlanTourDto toDTO(PlanTour planTour);

    PlanTour toEntity(PlanTourDto planTourDTO);
}
