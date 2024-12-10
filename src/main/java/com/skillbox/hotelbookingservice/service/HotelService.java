package com.skillbox.hotelbookingservice.service;

import com.skillbox.hotelbookingservice.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface HotelService {
    Page<Hotel> findAllHotel(PageRequest pageRequest);

    Hotel findByIdHotel(UUID hotelId);

    Hotel createHotel(Hotel hotel);

    Hotel updateHotel(UUID hotelId, Hotel hotel);

    void deleteHotel(UUID hotelId);
}
