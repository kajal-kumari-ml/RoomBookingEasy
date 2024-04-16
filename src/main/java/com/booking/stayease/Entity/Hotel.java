package com.booking.stayease.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=0l;

    private String name;

    private String location;

    private String description;

    private int availableRooms;

    private double pricePerNight;

    public Hotel() {
    }

    public Hotel(Long id,String name, String location, String description, int availableRooms, double pricePerNight) {
        this.id=id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.availableRooms = availableRooms;
        this.pricePerNight = pricePerNight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Hotel(id=" + this.getId() + ", name=" + this.getName() + ", location=" + this.getLocation() + ", description=" + this.getDescription() + ", availableRooms=" + this.getAvailableRooms() + ", pricePerNight=" + this.getPricePerNight() + ")";
    }
    
}
