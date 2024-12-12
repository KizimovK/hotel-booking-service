package com.skillbox.hotelbookingservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class UpsertRoomRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
    @Positive
    private int number;
    @Positive
    private int price;
    @Positive
    @Min(1)
    @Max(10)
    private int maxCapacity;

}