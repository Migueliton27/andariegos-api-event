package com.event.config.app.api_event.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EventTime")
public class EventTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eventTime")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_event", nullable = false)
    private Event event;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pattern", nullable = false)
    private AvailabilityPattern availabilityPattern;
        
    // Constructores
    
    public EventTime() {}
    
    public EventTime(Event event, AvailabilityPattern availabilityPattern) {
        this.event = event;
        this.availabilityPattern = availabilityPattern;
    }
    
    public EventTime(Event event, AvailabilityPattern availabilityPattern, LocalDateTime time) {
        this.event = event;
        this.availabilityPattern = availabilityPattern;    
    }
    
    // Getters y setters
    
    // Equals y hashCode (solo usando las claves foráneas)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventTime)) return false;
        EventTime that = (EventTime) o;
        return Objects.equals(event, that.event) &&
               Objects.equals(availabilityPattern, that.availabilityPattern);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public AvailabilityPattern getAvailabilityPattern() {
        return availabilityPattern;
    }

    public void setAvailabilityPattern(AvailabilityPattern availabilityPattern) {
        this.availabilityPattern = availabilityPattern;
    }

    @Override
    public int hashCode() {
        return Objects.hash(event, availabilityPattern);
    }
}
