package com.event.config.app.api_event.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.config.app.api_event.dto.AvailabilityPatternDto;
import com.event.config.app.api_event.mapper.AvailabilityPatternMapper;
import com.event.config.app.api_event.model.AvailabilityPattern;
import com.event.config.app.api_event.model.Event;
import com.event.config.app.api_event.model.EventTime;
import com.event.config.app.api_event.repository.AvailabilityPatternRepository;
import com.event.config.app.api_event.repository.EventTimeRepository;

@Service
public class AvailabilityPatternService {
    private final AvailabilityPatternRepository availabilityPatternRepository;
    private final AvailabilityPatternMapper availabilityPatternMapper;
    private final EventTimeRepository eventTimeRepository;

    public AvailabilityPatternService(AvailabilityPatternRepository availabilityPatternRepository, 
    AvailabilityPatternMapper availabilityPatternMapper, 
    EventTimeRepository eventTimeRepository) {
        this.availabilityPatternRepository = availabilityPatternRepository;
        this.availabilityPatternMapper = availabilityPatternMapper;
        this.eventTimeRepository = eventTimeRepository;
    }

    public void saveSlotsEvent(List<AvailabilityPatternDto> timeSlots, Event event) {

        for (AvailabilityPatternDto patternDto : timeSlots) {
                AvailabilityPattern pattern = this.availabilityPatternMapper.toEntity(patternDto);
                AvailabilityPattern savedPattern = availabilityPatternRepository.save(pattern);
                
                EventTime eventTime = new EventTime(event, savedPattern);
                eventTimeRepository.save(eventTime);
                
                event.getEventTimes().add(eventTime);
                savedPattern.getEventTimes().add(eventTime);
        }

        return;
    }
}
