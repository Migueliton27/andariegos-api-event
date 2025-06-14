package com.event.config.app.api_event.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.config.app.api_event.dto.AttendeeDto;
import com.event.config.app.api_event.dto.CreateEventDto;
import com.event.config.app.api_event.mapper.EventMapper;
import com.event.config.app.api_event.model.Event;
import com.event.config.app.api_event.model.Attendance;
import com.event.config.app.api_event.service.EventService;
import com.event.config.app.api_event.service.RegistrationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events/registration")
public class RegisterController {

    private final RegistrationService service;
    private final EventMapper mapper;

    public RegisterController(RegistrationService service) {
        this.service = service;
        this.mapper = null;
    }

    @GetMapping("/attendees/{id}")
    private ResponseEntity<List<?>> getAllEventAttendees(@PathVariable Long id){
        return ResponseEntity.ok().body(this.service.getEventAttendeesByEventId(id));
    }



    @PostMapping
    public ResponseEntity<?> addUserToEvent(@Valid @RequestBody() AttendeeDto attendance){
        String userId = attendance.getUserId();
        Long eventId = attendance.getEventId();

        Attendance newAttendance = service.addUserToEvent(
            eventId,
            userId
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(newAttendance);
    }
}
