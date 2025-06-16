package com.event.config.app.api_event.repository;


import com.event.config.app.api_event.model.PlanTour;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface PlanTourRepository extends JpaRepository<PlanTour, Integer> {
        @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PlanTour p WHERE p.tour.idTour = :tourId AND p.event.id = :eventId")
        boolean existsByTour_IdTourAndEvent_Id(Integer tourId, Long eventId);

        @Modifying
        @Transactional
        @Query("DELETE FROM PlanTour p WHERE p.tour.idTour = :tourId AND p.event.id NOT IN :eventIds")
        void deleteByTour_IdTourAndEvent_IdNotIn(Integer tourId, List<Long> eventIds);

        @Query("SELECT p.event.id FROM PlanTour p WHERE p.tour.idTour = :idTour")
        List<Long> findByTour_IdTour(Integer idTour);
}