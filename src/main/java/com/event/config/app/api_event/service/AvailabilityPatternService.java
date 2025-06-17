package com.event.config.app.api_event.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.event.config.app.api_event.dto.AvailabilityPatternDto;
import com.event.config.app.api_event.dto.UpdateAvailabilityPattern;
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

    public void updateSlotsEvent(List<UpdateAvailabilityPattern> timeSlots, Event event) {
        Map<Long, EventTime> existingSlots = event.getEventTimes().stream()
            .collect(Collectors.toMap(et -> et.getAvailabilityPattern().getId(), et -> et));
        
        for (UpdateAvailabilityPattern slotDto : timeSlots) {
            if (slotDto.isToDelete() && slotDto.getId() != null) {
                // Eliminar slot existente
                System.out.println("Eliminando slot con ID: " + slotDto.getId());
                EventTime eventTime = existingSlots.get(slotDto.getId());
                if (eventTime != null) {
                    event.getEventTimes().remove(eventTime);
                    eventTimeRepository.delete(eventTime);
                    availabilityPatternRepository.delete(eventTime.getAvailabilityPattern());
                }
            } else if (slotDto.getId() != null) {
                EventTime eventTime = existingSlots.get(slotDto.getId());
                if (eventTime != null) {
                    AvailabilityPattern pattern = eventTime.getAvailabilityPattern();
                    pattern.setDayOfWeek(slotDto.getDayOfWeek());
                    pattern.setStartTime(slotDto.getStartTime());
                    pattern.setEndTime(slotDto.getEndTime());
                    availabilityPatternRepository.save(pattern);
                }
            } else {
                
                // Crear nuevo slot
                AvailabilityPattern pattern = new AvailabilityPattern();
                pattern.setDayOfWeek(slotDto.getDayOfWeek());
                pattern.setStartTime(slotDto.getStartTime());
                pattern.setEndTime(slotDto.getEndTime());
                AvailabilityPattern savedPattern = availabilityPatternRepository.save(pattern);
                
                EventTime newEventTime = new EventTime(event, savedPattern);
                eventTimeRepository.save(newEventTime);
                event.getEventTimes().add(newEventTime);
            }
        }
    }
}
