package com.event.config.app.api_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.event.config.app.api_event.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e.name FROM Event e WHERE e.id = :id")
    String getNameById(Long id);
}
