package com.event.config.app.api_event.model;


import jakarta.persistence.*;

@Entity
@Table(name = "PlanTour")
public class PlanTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlan;


    @ManyToOne
    @JoinColumn(name = "id_tour", nullable = false)
    private Tour tour;



    @ManyToOne
    @JoinColumn(name = "id_event", nullable =  false)
    private Event event;


    // Default constructor
    public PlanTour() {
    }

    public PlanTour(Integer idTour, Long idEvent) {
        this.tour = new Tour(); // Tour vacío, solo con ID
        this.tour.setIdTour(idTour);

        this.event = new Event(); // Event vacío, solo con ID
        this.event.setIdEvent(idEvent);
    }

    // Getters and Setters
    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }



    public void setTourId(Integer idTour) {
        if (this.tour == null) {
            this.tour = new Tour();
        }
        this.tour.setIdTour(idTour);
    }

    public void setEventId(Long idEvent) {
        if (this.event == null) {
            this.event = new Event();
        }
        this.event.setIdEvent(idEvent);
    }
    public Integer getTourId() {
        return tour != null ? tour.getIdTour() : null;
    }

    public Long getEventId() {
        return event != null ? event.getIdEvent() : null;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}