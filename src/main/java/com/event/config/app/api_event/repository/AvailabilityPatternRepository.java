package com.event.config.app.api_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.config.app.api_event.model.AvailabilityPattern;

public interface AvailabilityPatternRepository extends JpaRepository<AvailabilityPattern, Long> {
}
