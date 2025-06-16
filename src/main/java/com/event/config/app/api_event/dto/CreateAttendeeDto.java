package com.event.config.app.api_event.dto;


import lombok.Data;

@Data
public class CreateAttendeeDto {
    private String userId;

    private Long eventId;

    public String getUserId()  { return userId; }
    public Long getEventId() { return eventId; }

    public void setUserId(String userId)   { this.userId = userId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }
}
