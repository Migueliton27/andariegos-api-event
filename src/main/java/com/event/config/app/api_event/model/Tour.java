package com.event.config.app.api_event.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTour;

    @Column(nullable = false)
    private String idUser;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    // Getters and Setters
    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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
}