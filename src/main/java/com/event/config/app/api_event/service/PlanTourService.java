package com.event.config.app.api_event.service;

import com.event.config.app.api_event.model.PlanTour;
import com.event.config.app.api_event.repository.PlanTourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanTourService {
    private final PlanTourRepository planTourRepository;

    public PlanTourService(PlanTourRepository planTourRepository) {
        this.planTourRepository = planTourRepository;
    }

    public List<PlanTour> getAllPlanTours() {
        return planTourRepository.findAll();
    }

    public PlanTour getPlanTourById(Integer id) {
        return planTourRepository.findById(id).orElse(null);
    }

    public PlanTour savePlanTour(PlanTour planTour) {
        return planTourRepository.save(planTour);
    }

    public void deletePlanTour(Integer id) {
        planTourRepository.deleteById(id);
    }
}