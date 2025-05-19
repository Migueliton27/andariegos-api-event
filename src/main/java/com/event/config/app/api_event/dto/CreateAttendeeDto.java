package com.event.config.app.api_event.dto;

import lombok.Data;

@Data
public class CreateAttendeeDto {
    private Long userId;

    private Long eventId;

    public Long getUserId()  { return userId; }
    public Long getEventId() { return eventId; }

    public void setUserId(Long userId)   { this.userId = userId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }
}
