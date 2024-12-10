package com.skillbox.hotelbookingservice.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertHotelRequest {

    @NotNull
    private String name;

    @NotNull
    private String announcementTitle;

    @NotNull
    private String city;

    @NotNull
    private String address;

    @PositiveOrZero
    private double distanceFromCityCenter;
}
