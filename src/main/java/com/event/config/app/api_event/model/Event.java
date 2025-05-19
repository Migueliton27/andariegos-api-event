package com.event.config.app.api_event.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "id_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime date;

    private String city;

    private String address;

    @Column(name = "available_spots")
    private Integer availableSpots;

    private BigDecimal price;

    private String image1;

    private String image2;

    private String image3;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Attendance> attendances = new HashSet<>();

    public Event() {
    }

    public Event(Long idEvent, String name, String description, LocalDateTime date, String city, String address,
                 Integer availableSpots, BigDecimal price, String image1, String image2, String image3) {
        this.id = idEvent;
        this.name = name;
        this.description = description;
        this.date = date;
        this.city = city;
        this.address = address;
        this.availableSpots = availableSpots;
        this.price = price;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public Long getIdEvent() {
        return id;
    }

    public void setIdEvent(Long idEvent) {
        this.id = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(Integer availableSpots) {
        this.availableSpots = availableSpots;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    


    // Getters y setters
}
