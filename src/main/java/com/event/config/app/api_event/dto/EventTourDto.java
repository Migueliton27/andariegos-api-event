package com.event.config.app.api_event.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventTourDto {
    public EventTourDto(long idEvent, String name, String descripcion, String image, String address, BigDecimal price) {
        this.idEvent = idEvent;
        this.nameEvent = name;
        this.address = address;
        this.image = image;
        this.price = price;
        this.description = descripcion;
    }
    private long idEvent;
    private String nameEvent;
    private String description;
    private String image;
    private String address;
    private BigDecimal price;
}
