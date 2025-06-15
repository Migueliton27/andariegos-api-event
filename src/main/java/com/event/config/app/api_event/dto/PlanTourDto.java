package com.event.config.app.api_event.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlanTourDto {
    private Integer idPlan;

    @NotNull(message = "idTour cannot be null")
    @NotBlank(message = "idTour cannot be blank")
    private Integer idTour;

    @NotNull(message = "idEvent cannot be null")
    @NotBlank(message = "idEvent cannot be blank")
    private Integer idEvent;

    // Getters and Setters
    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }
}