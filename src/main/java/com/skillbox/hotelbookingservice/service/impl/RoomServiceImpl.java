package com.skillbox.hotelbookingservice.service.impl;

import com.skillbox.hotelbookingservice.entity.Hotel;
import com.skillbox.hotelbookingservice.entity.Room;
import com.skillbox.hotelbookingservice.exception.EntityNotFoundException;
import com.skillbox.hotelbookingservice.repository.RoomRepository;
import com.skillbox.hotelbookingservice.service.HotelService;
import com.skillbox.hotelbookingservice.service.RoomService;
import com.skillbox.hotelbookingservice.utils.CopyUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelService hotelService;
    @Override
    public Room findByIdRoom(UUID roomId) {
        return roomRepository.findById(roomId).orElseThrow(() ->
                new EntityNotFoundException(
                        MessageFormat.format("Комната с таким ID {0} не найден", roomId)));
    }

    @Override
    @Transactional
    public Room createRoomInHotel(UUID hotelId, Room room) {
        Hotel hotel = hotelService.findByIdHotel(hotelId);
        room.setHotel(hotel);
        return roomRepository.saveAndFlush(room);
    }

    @Override
    @Transactional
    public Room updateRoom(UUID roomId, Room room) {
        Room existedRoom = findByIdRoom(roomId);
        CopyUtils.notNullCopyProperties(room, existedRoom);
        return roomRepository.saveAndFlush(room);
    }

    @Override
    @Transactional
    public void deleteRoom(UUID roomId) {
        roomRepository.deleteById(roomId);
    }
}
