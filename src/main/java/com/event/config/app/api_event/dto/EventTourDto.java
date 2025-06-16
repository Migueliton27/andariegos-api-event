package com.event.config.app.api_event.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventTourDto {
    public EventTourDto(long idEvent, String name) {
        this.idEvent = idEvent;
        this.nameEvent = name;
    }
    private long idEvent;
    private String nameEvent;
}
