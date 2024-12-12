package com.skillbox.hotelbookingservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertHotelRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String announcementTitle;

    @NotBlank
    private String city;

    @NotBlank
    private String address;

    @PositiveOrZero
    private double distanceFromCityCenter;
}
