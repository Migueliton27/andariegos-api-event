package com.event.config.app.api_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.config.app.api_event.model.Event;

public interface EventRepository extends JpaRepository<Event, String> {
}
