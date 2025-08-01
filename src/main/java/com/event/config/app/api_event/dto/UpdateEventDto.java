package com.event.config.app.api_event.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateEventDto {
    private String name;
    private String description;
    // private LocalDate date;
    private String city;
    private String address;
    // private Integer availableSpots;
    private BigDecimal price;
    private String image1;
    private String image2;
    private String image3;

    @Nullable
    private List<UpdateAvailabilityPattern> timeSlots;
}