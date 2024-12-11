package com.skillbox.hotelbookingservice.dto.response;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class RoomResponse {

    private UUID uuid;
    private String name;
    private String description;
    private int number;
    private int price;
    private int maxCapacity;
    private Instant unavailableDateBegin;
    private Instant unavailableDateEnd;
    private HotelResponse hotelResponse;

}
