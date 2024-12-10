package com.skillbox.hotelbookingservice.mapper;

import com.skillbox.hotelbookingservice.dto.request.UpsertHotelRequest;
import com.skillbox.hotelbookingservice.dto.response.HotelResponse;
import com.skillbox.hotelbookingservice.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {

    HotelResponse toHotelResponse(Hotel hotel);

    Hotel toHotel(UpsertHotelRequest request);
}
