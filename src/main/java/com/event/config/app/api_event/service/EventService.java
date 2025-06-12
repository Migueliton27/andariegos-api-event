package com.event.config.app.api_event.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.config.app.api_event.model.Event;
import com.event.config.app.api_event.repository.AvailabilityPatternRepository;
import com.event.config.app.api_event.repository.EventRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final AvailabilityPatternRepository availabilityPatternRepository;

    public EventService(EventRepository eventRepository, AvailabilityPatternRepository availabilityPatternRepository) {
        this.eventRepository = eventRepository;
        this.availabilityPatternRepository = availabilityPatternRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
