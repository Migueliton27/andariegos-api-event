package com.event.config.app.api_event.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.config.app.api_event.dto.AvailabilityPatternDto;
import com.event.config.app.api_event.dto.CreateEventDto;
import com.event.config.app.api_event.dto.UpdateEventDto;
import com.event.config.app.api_event.exceptions.ResourceNotFoundException;
import com.event.config.app.api_event.mapper.EventMapper;
import com.event.config.app.api_event.model.Event;
import com.event.config.app.api_event.service.AvailabilityPatternService;
import com.event.config.app.api_event.service.EventService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;
    private final AvailabilityPatternService availabilityPatternService;
    private final EventMapper mapper;

    public EventController(EventService service,
                           AvailabilityPatternService availabilityPatternService,
                           EventMapper mapper) {
        this.service = service;
        this.mapper = mapper;
        this.availabilityPatternService = availabilityPatternService;
    }

    @GetMapping
    private ResponseEntity<List<?>> getAllEvents(){
        return ResponseEntity.ok().body(this.service.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvent(@PathVariable Long id) throws ResourceNotFoundException {
        Event event = this.service.getEventById(id);
        if (event == null) {
            throw new ResourceNotFoundException("No event found with the code: " + id);
        }
        return ResponseEntity.ok().body(mapper.toDto(event));
    }

    @PostMapping
    public ResponseEntity<?> postEvent(@Valid @RequestBody CreateEventDto eventDto) {
        Event saved = service.createEvent(eventDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(
        @PathVariable Long id,
        @Valid @RequestBody UpdateEventDto dto
    ) throws ResourceNotFoundException {

        Event existing = this.service.getEventById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("No event found with the code: " + id);
        }

        mapper.updateEntity(existing, dto);

        Event updated = service.saveEvent(existing);

        return ResponseEntity.ok(mapper.toDto(updated));
    }

    private static final Logger log = LoggerFactory.getLogger(EventController.class);


    @GetMapping("name/{eventId}")
    public ResponseEntity<String> getEventName(@PathVariable Long eventId) {
        log.info("esto es un string");
        log.info(service.getEventNameById(eventId).getClass().getName());
        String eventName = service.getEventNameById(eventId);
        if (eventName == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventName);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);;
    }
}
