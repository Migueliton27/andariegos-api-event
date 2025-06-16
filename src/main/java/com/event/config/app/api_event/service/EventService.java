package com.event.config.app.api_event.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.config.app.api_event.dto.AvailabilityPatternDto;
import com.event.config.app.api_event.dto.CreateEventDto;
import com.event.config.app.api_event.mapper.EventMapper;
import com.event.config.app.api_event.model.Event;
import com.event.config.app.api_event.repository.AvailabilityPatternRepository;
import com.event.config.app.api_event.repository.EventRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final AvailabilityPatternService availabilityPatternService;
    private final EventMapper mapper;

    public EventService(EventRepository eventRepository, AvailabilityPatternService availabilityPatternService, EventMapper mapper) {
        this.eventRepository = eventRepository;
        this.availabilityPatternService = availabilityPatternService;
        this.mapper = mapper;
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
    

    public Event createEvent(CreateEventDto eventDto) {

        Event event = mapper.toEntity(eventDto);
        Event saved = eventRepository.save(event);

        List<AvailabilityPatternDto> timeSlots = eventDto.getTimeSlots();
        availabilityPatternService.saveSlotsEvent(timeSlots, saved);

        return saved;
    }


    public String getEventNameById(Long id){
        return eventRepository.getNameById(id);
    }
}
