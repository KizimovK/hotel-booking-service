package com.skillbox.hotelbookingservice.service.impl;

import com.skillbox.hotelbookingservice.entity.Hotel;
import com.skillbox.hotelbookingservice.exception.EntityNotFoundException;
import com.skillbox.hotelbookingservice.repository.HotelRepository;
import com.skillbox.hotelbookingservice.service.HotelService;
import com.skillbox.hotelbookingservice.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public Page<Hotel> findAllHotel(PageRequest pageRequest) {
        return hotelRepository.findAll(pageRequest);
    }

    @Override
    public Hotel findByIdHotel(UUID hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Отель с таким ID {0} не найден", hotelId)));
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.saveAndFlush(hotel);
    }

    @Override
    public Hotel updateHotel(UUID hotelId, Hotel hotel) {
        Hotel existedHotel = findByIdHotel(hotelId);
        CopyUtils.notNullCopyProperties(hotel, existedHotel);
        return hotelRepository.saveAndFlush(existedHotel);
    }

    @Override
    public void deleteHotel(UUID hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
