package com.event.config.app.api_event.repository;


import com.event.config.app.api_event.model.PlanTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanTourRepository extends JpaRepository<PlanTour, Integer> {
}