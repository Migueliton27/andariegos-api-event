package com.event.config.app.api_event.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    @Column(name = "id_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String city;

    private String address;


    private BigDecimal price;

    private String image1;

    private String image2;

    private String image3;

    @OneToMany(mappedBy = "Event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Attendance> attendances = new HashSet<>();

    public Event() {
    }

    public Event(Long idEvent, String name, String description, String city, String address, BigDecimal price, String image1, String image2, String image3) {
        this.id = idEvent;
        this.name = name;
        this.description = description;
        this.city = city;
        this.address = address;
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
