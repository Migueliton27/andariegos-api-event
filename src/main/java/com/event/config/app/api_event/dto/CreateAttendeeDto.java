package com.event.config.app.api_event.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.cglib.core.Local;

import lombok.Data;

@Data
public class CreateAttendeeDto {
    private String userId;

    private Long eventId;

    private LocalTime booking_time;
    
    private LocalDate booking_date;

    public String getUserId()  { return userId; }
    public Long getEventId() { return eventId; }

    public void setUserId(String userId)   { this.userId = userId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public LocalTime getBooking_time() { return this.booking_time; }
    public void setBooking_time(LocalTime booking_time) { this.booking_time = booking_time; }

    public LocalDate getBooking_date() { return this.booking_date; }
    public void setBooking_date(LocalDate booking_date) { this.booking_date = booking_date; }
}
