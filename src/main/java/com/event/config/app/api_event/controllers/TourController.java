package com.event.config.app.api_event.controllers;


import com.event.config.app.api_event.dto.TourDto;
import com.event.config.app.api_event.mapper.TourMapper;
import com.event.config.app.api_event.model.Tour;
import com.event.config.app.api_event.service.TourService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tours")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<TourDto> getAllTours() {
        List<Tour> tours = tourService.getAllTours();
        return tours.stream().map(TourMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourDto> getTourById(@PathVariable Integer id) {
        Tour tour = tourService.getTourById(id);
        if (tour != null) {
            return ResponseEntity.ok(TourMapper.INSTANCE.toDTO(tour));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TourDto createTour(@Valid @RequestBody TourDto tourDTO) {
        Tour tour = TourMapper.INSTANCE.toEntity(tourDTO);
        Tour savedTour = tourService.saveTour(tour);
        return TourMapper.INSTANCE.toDTO(savedTour);
    }

    @PutMapping("/{id}")
    public TourDto updateTour(@PathVariable Integer id, @Valid @RequestBody TourDto tourDTO) {
        Tour tour = tourService.getTourById(id);
        if (tour != null) {
            Tour updatedTour = TourMapper.INSTANCE.toEntity(tourDTO);
            updatedTour.setIdTour(id);
            return TourMapper.INSTANCE.toDTO(tourService.saveTour(updatedTour));
        } else {
            throw new RuntimeException("Tour not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable Integer id) {
        tourService.deleteTour(id);
    }
}