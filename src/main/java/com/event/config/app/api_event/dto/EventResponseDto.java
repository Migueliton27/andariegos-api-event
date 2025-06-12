package com.event.config.app.api_event.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class EventResponseDto {

    private Long id;
    private String name;
    private String description;
    private String city;
    private String address;
    private BigDecimal price;
    private String image1;
    private String image2;
    private String image3;
    private List<EventTimeResponseDto> eventTimes;
}
