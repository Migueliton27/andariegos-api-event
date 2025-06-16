package com.event.config.app.api_event.model;


import jakarta.persistence.*;

@Entity
@Table(name = "PlanTour")
public class PlanTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlan;

    @Column(nullable = false)
    private Integer idTour;

    @Column(nullable = false)
    private Integer idEvent;


    // Default constructor
    public PlanTour() {
    }

    // Constructor with idTour and idEvent
    public PlanTour(Integer idTour, Integer idEvent) {
        this.idTour = idTour;
        this.idEvent = idEvent;
    }

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