package com.event.config.app.api_event.service;


import com.event.config.app.api_event.dto.EventTourDto;
import com.event.config.app.api_event.dto.TourDto;
import com.event.config.app.api_event.mapper.TourMapper;
import com.event.config.app.api_event.model.PlanTour;
import com.event.config.app.api_event.model.Tour;
import com.event.config.app.api_event.repository.EventRepository;
import com.event.config.app.api_event.repository.PlanTourRepository;
import com.event.config.app.api_event.repository.TourRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.EventTarget;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final PlanTourRepository planTourRepository;
    private final EventRepository eventRepository;


    private static final Logger log = LoggerFactory.getLogger(TourService.class);

    public TourService(TourRepository tourRepository, PlanTourRepository planTourRepository, EventRepository eventRepository) {
        this.tourRepository = tourRepository;
        this.planTourRepository = planTourRepository;
        this.eventRepository = eventRepository;
    }


    public TourDto getTourById(Integer id) {
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found"));
        List<Long> eventsIds = planTourRepository.findByTour_IdTour(id);

        log.info("MY IDS tour: {} (total: {})", eventsIds, eventsIds.size());

        List<EventTourDto> events = eventRepository.findByIdIn(eventsIds)
                                              .stream()
                                              .map(event -> new EventTourDto(event.getIdEvent(), event.getName(), event.getDescription(), event.getImage1(), event.getAddress(), event.getPrice()))
                                              .collect(Collectors.toList());

        log.info("MY events tour: {} (total: {})", events, events.size());

        TourDto tourDTO = TourMapper.INSTANCE.toDTO(tour);
        tourDTO.setEventsIds(eventsIds);
        tourDTO.setEvents(TourMapper.INSTANCE.toEventDTOs(eventsIds, events));

        return tourDTO;
    }

    public List<TourDto> getAllTours() {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream().map(tour -> {
            List<Long> eventsIds = planTourRepository.findByTour_IdTour(tour.getIdTour());

            log.info("MY IDS: {} (total: {})", eventsIds, eventsIds.size());

            List<EventTourDto> events = eventRepository.findByIdIn(eventsIds)
                                                  .stream()
                                                  .map(event -> new EventTourDto(event.getIdEvent(), event.getName(), event.getDescription(), event.getImage1(), event.getAddress(), event.getPrice()))
                                                  .collect(Collectors.toList());

            TourDto tourDTO = TourMapper.INSTANCE.toDTO(tour);
            tourDTO.setEventsIds(eventsIds);
            tourDTO.setEvents(TourMapper.INSTANCE.toEventDTOs(eventsIds, events));

            return tourDTO;
        }).collect(Collectors.toList());
    }





    public void deleteTour(Integer id) {
        tourRepository.deleteById(id);
    }

    

    public Tour saveTour(Tour tour, List<Long> eventsIds) {
        Tour savedTour = tourRepository.save(tour);
        Integer idTour = savedTour.getIdTour();

        // Create or update PlanTour entries
        for (long idEvent : eventsIds) {
            if (!planTourRepository.existsByTour_IdTourAndEvent_Id(idTour, idEvent)) {
                planTourRepository.save(new PlanTour(idTour, idEvent));
            }
        }

        return savedTour;
    }

    public Tour updateTour(Integer id, Tour tour, List<Long> eventsIds) {
        Tour existingTour = tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found"));
        existingTour.setIdUser(tour.getIdUser());
        existingTour.setName(tour.getName());
        existingTour.setDescription(tour.getDescription());

        Integer tourId = existingTour.getIdTour();

        // Remove existing PlanTour entries that are not in the new eventsIds
        planTourRepository.deleteByTour_IdTourAndEvent_IdNotIn(tourId, eventsIds);

        // Create or update PlanTour entries
        for (Long eventId : eventsIds) {
            if (!planTourRepository.existsByTour_IdTourAndEvent_Id(tourId, eventId)) {
                planTourRepository.save(new PlanTour(tourId, eventId));
            }
        }

        return tourRepository.save(existingTour);
    }
}