package com.event.config.app.api_event.dto;


import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TourDto {

    
    private Integer idTour;
    
    @NotNull(message = "idUser cannot be null")
    @NotBlank(message = "idUser cannot be blank")
    private String idUser;

    @NotNull(message = "name cannot be Null")
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotNull(message = "description cannot be Null")
    @NotBlank(message = "description cannot be blank")
    private String description;

    private List<Long> eventsIds;

    private List<EventTourDto> events;

    // Getters and Setters
    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public List<Long> getEventIds() {
        return eventsIds;
    }

    public void setEventids(List<Long> eventIds) {
        this.eventsIds = eventIds;
    }


    public List<EventTourDto> getEvents() {
        return events;
    }

    public void setEvents(List<EventTourDto> events) {
        this.events = events;
    }

}