package com.skillbox.hotelbookingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String name;

    private String announcementTitle;

    private String city;

    private String address;

    private double distanceFromCityCenter;

    private double rating;

    private int numberOfRatings;
}
