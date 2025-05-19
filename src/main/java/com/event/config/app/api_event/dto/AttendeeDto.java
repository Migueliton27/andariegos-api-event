package com.event.config.app.api_event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class AttendeeDto {
    
    @Getter 
    Long attendanceId;
    @Getter 
    String userId;
}
