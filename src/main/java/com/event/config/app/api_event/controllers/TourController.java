package com.event.config.app.api_event.controllers;


import com.event.config.app.api_event.dto.TourDto;
import com.event.config.app.api_event.mapper.TourMapper;
import com.event.config.app.api_event.model.Tour;
import com.event.config.app.api_event.service.TourService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tours")
public class TourController {
    private static final Logger log = LoggerFactory.getLogger(TourController.class);
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public ResponseEntity<List<TourDto>> getAllTours() {
        List<TourDto> tours = tourService.getAllTours();
        return ResponseEntity.ok(tours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourDto> getTourById(@PathVariable Integer id) {
        log.info("HOLAAA");
        TourDto tour = tourService.getTourById(id);
        if (tour != null) {
            return ResponseEntity.ok(tour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @PostMapping
    public TourDto createTour(@Valid @RequestBody TourDto tourDTO) {
        Tour tour = TourMapper.INSTANCE.toEntity(tourDTO);
        Tour savedTour = tourService.saveTour(tour, tourDTO.getEventsIds());
        return TourMapper.INSTANCE.toDTO(savedTour);
    }

    @PutMapping("/{id}")
    public TourDto updateTour(@PathVariable Integer id, @Valid @RequestBody TourDto tourDTO) {
        Tour tour = TourMapper.INSTANCE.toEntity(tourDTO);
        Tour updatedTour = tourService.updateTour(id, tour, tourDTO.getEventsIds());
        return TourMapper.INSTANCE.toDTO(updatedTour);
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable Integer id) {
        tourService.deleteTour(id);
    }
}