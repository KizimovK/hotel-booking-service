package com.skillbox.hotelbookingservice.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class HotelResponse {

    private UUID uuid;

    private String name;

    private String announcementTitle;

    private String city;

    private String address;

    private double distanceFromCityCenter;

    private double rating;

    private int numberOfRatings;

}
