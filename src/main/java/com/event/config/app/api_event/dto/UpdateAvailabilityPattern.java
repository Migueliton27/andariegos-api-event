package com.event.config.app.api_event.dto;

import java.time.LocalTime;
import lombok.Data;

@Data
public class UpdateAvailabilityPattern {
    private Long id; // null para slots nuevos, valor para existentes
    private Integer dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean toDelete = false; // Flag para eliminación
}