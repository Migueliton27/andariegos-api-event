package com.event.config.app.api_event.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.config.app.api_event.dto.AttendanceDeleteRequest;
import com.event.config.app.api_event.dto.CreateAttendeeDto;
import com.event.config.app.api_event.exceptions.ResourceNotFoundException;
import com.event.config.app.api_event.mapper.EventMapper;
import com.event.config.app.api_event.model.Attendance;
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
    public ResponseEntity<?> addUserToEvent(@Valid @RequestBody() CreateAttendeeDto attendance){
        String userId = attendance.getUserId();
        Long eventId = attendance.getEventId();
        LocalTime bookingTime = attendance.getBooking_time() != null ? attendance.getBooking_time() : null;
        LocalDate bookingDate = attendance.getBooking_date() != null ? attendance.getBooking_date() : null;


        Attendance newAttendance = service.addUserToEvent(
            eventId,
            userId,
            bookingTime,
            bookingDate
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(newAttendance);
    }


    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> deleteAttendance(
            @PathVariable Long eventId,
            @RequestBody AttendanceDeleteRequest request) {
        
        Attendance existing = service.FindByAttendeUserEvent(request.getUserId(), eventId);
        if (existing == null) {
            throw new ResourceNotFoundException("No attendance found with the code: " + eventId + "user: " + request.getUserId());
        }       
        service.deleteAttendeeUserEvent(request.getUserId(), eventId);
        return ResponseEntity.ok("Eliminado con exito");
    }
}
