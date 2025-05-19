package com.event.config.app.api_event.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.event.config.app.api_event.dto.AttendeeDto;
import com.event.config.app.api_event.model.Attendance;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    @Mapping(source = "id", target = "attendanceId")
    AttendeeDto toDto(Attendance attendance);

    // Mapea listas
    List<AttendeeDto> toDtoList(List<Attendance> attendanceList);
}


