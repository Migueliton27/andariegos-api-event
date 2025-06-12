package com.event.config.app.api_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.config.app.api_event.model.EventTime;

public interface EventTimeRepository extends JpaRepository<EventTime, Long> {
}