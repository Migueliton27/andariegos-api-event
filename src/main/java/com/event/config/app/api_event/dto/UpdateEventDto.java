package com.event.config.app.api_event.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateEventDto {
    private String name;
    private String description;
    private LocalDateTime date;
    private String city;
    private String address;
    private Integer availableSpots;
    private BigDecimal price;
    private String image1;
    private String image2;
    private String image3;
}