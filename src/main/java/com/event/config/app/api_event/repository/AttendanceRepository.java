package com.event.config.app.api_event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.config.app.api_event.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    boolean existsByUserIdAndEventId(String userId, Long eventId);

    List<Attendance> findByEventId(Long eventId);
}
