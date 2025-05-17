package com.event.config.app.api_event.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateEventDto {
    @NotNull
    private String idEvent;
}