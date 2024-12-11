package com.skillbox.hotelbookingservice.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.springframework.data.domain.PageRequest;

@Data
public class PaginationRequest {

    @NotNull
    @Positive
    private int pageSize = 10;

    @NotNull
    @PositiveOrZero
    private int pageNumber = 0;

    public PageRequest pageRequest() {
        return PageRequest.of(pageNumber, pageSize);
    }
}
