package com.skillbox.hotelbookingservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionValidResponse {

    private Set<ValidResponse> validationResponses = new HashSet<>();

    public void addValidResponse(ValidResponse validResponse) {
        if (validResponse != null) {
            validationResponses.add(validResponse);
        }
    }

    @Data
    @Builder
    public static class ValidResponse {
        private String field;
        private String message;
    }

}
