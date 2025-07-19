package com.event.config.app.api_event.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.event.config.app.api_event.dto.AttendeeDto;
import com.event.config.app.api_event.exceptions.ResourceNotFoundException;
import com.event.config.app.api_event.mapper.AttendanceMapper;
import com.event.config.app.api_event.model.Event;
import com.event.config.app.api_event.model.Attendance;
import com.event.config.app.api_event.repository.AttendanceRepository;
import com.event.config.app.api_event.repository.EventRepository;

import jakarta.transaction.Transactional;

@Service
public class RegistrationService {
    private final AttendanceRepository attendanceRepository;
    private final EventRepository eventRepo;
    private final AttendanceMapper mapper;

    public RegistrationService(AttendanceRepository attendanceRepository, EventRepository eventRepo, AttendanceMapper mapper) {
        this.eventRepo = eventRepo;
        this.attendanceRepository = attendanceRepository;
        this.mapper = mapper;
    }

    public List<Attendance> getAllUserEvents() {
        return attendanceRepository.findAll();
    }

    @Transactional
    public List<AttendeeDto> getEventAttendeesByEventId(Long id) {
        List<Attendance> list = attendanceRepository.findByEventId(id);
        System.out.println("List of attendees: " + list);
        for (Attendance attendance : list) {
            System.out.println("Attendee: " + attendance.getUserId() + ", Event ID: " + attendance.getEvent().getId());
        }
        
        return AttendanceMapper.toDtoList(list);
    }

    @Transactional
    public Attendance addUserToEvent(Long eventId, String userId, LocalTime bookingTime, LocalDate bookingDate) {

        if (attendanceRepository.existsByUserIdAndEventId(userId, eventId)) 
            throw new ResourceNotFoundException("The user is already registered in the event");

        Event event = eventRepo.findById(eventId)
                     .orElseThrow(() -> new ResourceNotFoundException("The event doesn´t exist with the eventId: "+eventId));

        Attendance attendee = new Attendance();
    
        attendee.setEvent(event);
        attendee.setUserId(userId);
        attendee.setBookingTime(bookingTime);
        attendee.setBookingDate(bookingDate);

        return attendanceRepository.save(attendee);
    }


    public void deleteUserEvent(Long id) {
        attendanceRepository.deleteById(id);
    }

    public Attendance FindByAttendanceId(Long id){
        return attendanceRepository.findById(id).orElse(null);
    }

}
