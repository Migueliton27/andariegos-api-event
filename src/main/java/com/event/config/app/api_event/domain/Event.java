package com.event.config.app.api_event.domain;

public class Event {
    private String id_event;

    private String name;

    private String description;

    private String date;

    private String city;

    private String address;

    private Integer available_spots;

    private Double price;

    private String image1;

    private String image2;

    private String image3;

    public Event(
        String id_event, String name, String description, String date, String city, String address, Integer available_spots, Double price, 
        String image1, String image2, String image3
    ) {
        this.id_event = id_event;
        this.name = name;
        this.description = description;
        this.date = date;
        this.city = city;
        this.address = address;
        this.available_spots = available_spots;
        this.price = price;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public String getId_event() {
        return id_event;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAvailable_spots() {
        return available_spots;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setId_event(String id_event) {
        this.id_event = id_event;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvailable_spots(Integer available_spots) {
        this.available_spots = available_spots;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    

}
