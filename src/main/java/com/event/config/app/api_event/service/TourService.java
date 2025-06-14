package com.event.config.app.api_event.service;


import com.event.config.app.api_event.model.Tour;
import com.event.config.app.api_event.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour getTourById(Integer id) {
        return tourRepository.findById(id).orElse(null);

    }

    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public void deleteTour(Integer id) {
        tourRepository.deleteById(id);
    }
}