package com.event.config.app.api_event.repository;


import com.event.config.app.api_event.model.PlanTour;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface PlanTourRepository extends JpaRepository<PlanTour, Integer> {
        boolean existsByIdTourAndIdEvent(Integer tourId, Integer eventId);

        @Modifying
        @Transactional
        void deleteByIdTourAndIdEventNotIn(Integer tourId, Set<Integer> eventIds);
}