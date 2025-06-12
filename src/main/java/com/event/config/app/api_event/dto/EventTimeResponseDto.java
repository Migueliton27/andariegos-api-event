package com.event.config.app.api_event.dto;

import lombok.Data;

@Data
public class EventTimeResponseDto {
    private Long id;
    private AvailabilityPatternDto availabilityPattern;
}