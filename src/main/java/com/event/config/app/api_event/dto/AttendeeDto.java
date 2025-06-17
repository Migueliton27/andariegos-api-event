package com.event.config.app.api_event.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@AllArgsConstructor
@Getter
@Setter
public class AttendeeDto {
    

    Long attendanceId;


    @NotNull(message = "idEvent cannot be null")
    private Long idEvent;


    @NotBlank(message = "idUser cannot be blank")
    private String idUser;

    @NotNull(message = "bookingTime cannot be null")
    private LocalTime bookingTime;


    @NotNull(message = "bookingDate cannot be null")
    private LocalDate bookingDate;
}
