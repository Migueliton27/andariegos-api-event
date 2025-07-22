package com.event.config.app.api_event.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.event.config.app.api_event.model.Attendance;

import jakarta.transaction.Transactional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    boolean existsByUserIdAndEventId(String userId, Long eventId);

    List<Attendance> findByEventId(Long eventId);

    @Query("SELECT a FROM Attendance a WHERE a.userId = :userId AND a.event.id = :eventId")
    Attendance findByUserIdAndEventId(@Param("userId") String idUser, @Param("eventId") Long idEvent);

    @Modifying
    @Transactional
    @Query("DELETE FROM Attendance a WHERE a.userId = :userId AND a.event.id = :eventId")
    void deleteByUserIdAndIdEventId(@Param("userId") String idUser, @Param("eventId") Long idEvent);

}
