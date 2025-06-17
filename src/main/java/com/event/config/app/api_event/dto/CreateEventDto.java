package com.event.config.app.api_event.dto;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.event.config.app.api_event.model.Event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CreateEventDto {

  @NotNull(message = "Name is required")
  @NotBlank(message = "Name is required")
  private String name;

  @NotNull(message = "Description is required")
  @NotBlank(message = "Description is required")
  private String description;

  @NotNull(message = "At least one time slot is required")
  @Size(min = 1, message = "At least one time slot is required")
  @Size(max = 7, message = "A maximum of 7 time slots is allowed")
  private List<AvailabilityPatternDto> timeSlots;

  @NotBlank(message = "City is required")
  @NotNull(message = "City is required")
  private String city;

  @NotNull(message = "Address is required")
  @NotBlank(message = "Address is required")
  private String address;

  // @NotNull(message = "availableSpots is required")
  // private Integer availableSpots;
  
  @NotNull(message = "Price is required")
  private BigDecimal price;

  private String image1;
  private String image2;
  private String image3;

}
