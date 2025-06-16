package com.event.config.app.api_event.service;


import com.event.config.app.api_event.model.PlanTour;
import com.event.config.app.api_event.model.Tour;
import com.event.config.app.api_event.repository.PlanTourRepository;
import com.event.config.app.api_event.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final PlanTourRepository planTourRepository;

    public TourService(TourRepository tourRepository, PlanTourRepository planTourRepository) {
        this.tourRepository = tourRepository;
        this.planTourRepository = planTourRepository;
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour getTourById(Integer id) {
        return tourRepository.findById(id).orElse(null);

    }


    public void deleteTour(Integer id) {
        tourRepository.deleteById(id);
    }

    

    public Tour saveTour(Tour tour, Set<Integer> eventsIds) {
        Tour savedTour = tourRepository.save(tour);
        Integer idTour = savedTour.getIdTour();

        // Create or update PlanTour entries
        for (Integer idEvent : eventsIds) {
            if (!planTourRepository.existsByIdTourAndIdEvent(idTour, idEvent)) {
                planTourRepository.save(new PlanTour(idTour, idEvent));
            }
        }

        return savedTour;
    }

    public Tour updateTour(Integer id, Tour tour, Set<Integer> eventsIds) {
        Tour existingTour = tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found"));
        existingTour.setIdUser(tour.getIdUser());
        existingTour.setName(tour.getName());
        existingTour.setDescription(tour.getDescription());

        Integer tourId = existingTour.getIdTour();

        // Remove existing PlanTour entries that are not in the new eventsIds
        planTourRepository.deleteByIdTourAndIdEventNotIn(tourId, eventsIds);

        // Create or update PlanTour entries
        for (Integer eventId : eventsIds) {
            if (!planTourRepository.existsByIdTourAndIdEvent(tourId, eventId)) {
                planTourRepository.save(new PlanTour(tourId, eventId));
            }
        }

        return tourRepository.save(existingTour);
    }
}