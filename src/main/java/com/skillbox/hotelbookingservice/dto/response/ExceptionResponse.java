package com.skillbox.hotelbookingservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ExceptionResponse {

    private String message;

    private String description;
}
