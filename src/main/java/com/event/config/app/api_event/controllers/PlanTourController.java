package com.event.config.app.api_event.controllers;

import com.event.config.app.api_event.dto.PlanTourDto;
import com.event.config.app.api_event.mapper.PlanTourMapper;
import com.event.config.app.api_event.model.PlanTour;
import com.event.config.app.api_event.service.PlanTourService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/plans")
public class PlanTourController {
    private final PlanTourService planTourService;

    public PlanTourController(PlanTourService planTourService) {
        this.planTourService = planTourService;
    }

    @GetMapping
    public List<PlanTourDto> getAllPlanTours() {
        List<PlanTour> planTours = planTourService.getAllPlanTours();
        return planTours.stream().map(PlanTourMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanTourDto> getPlanTourById(@PathVariable Integer id) {
        PlanTour planTour = planTourService.getPlanTourById(id);
        if (planTour != null) {
            return ResponseEntity.ok(PlanTourMapper.INSTANCE.toDTO(planTour));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PlanTourDto createPlanTour(@Valid @RequestBody PlanTourDto planTourDTO) {
        PlanTour planTour = PlanTourMapper.INSTANCE.toEntity(planTourDTO);
        PlanTour savedPlanTour = planTourService.savePlanTour(planTour);
        return PlanTourMapper.INSTANCE.toDTO(savedPlanTour);
    }

    @PutMapping("/{id}")
    public PlanTourDto updatePlanTour(@PathVariable Integer id, @Valid @RequestBody PlanTourDto planTourDTO) {
        PlanTour planTour = planTourService.getPlanTourById(id);
        if (planTour != null) {
            PlanTour updatedPlanTour = PlanTourMapper.INSTANCE.toEntity(planTourDTO);
            updatedPlanTour.setIdPlan(id);
            return PlanTourMapper.INSTANCE.toDTO(planTourService.savePlanTour(updatedPlanTour));
        } else {
            throw new RuntimeException("PlanTour not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deletePlanTour(@PathVariable Integer id) {
        planTourService.deletePlanTour(id);
    }
}