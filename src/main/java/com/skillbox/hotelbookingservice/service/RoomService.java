package com.skillbox.hotelbookingservice.service;

import com.skillbox.hotelbookingservice.entity.Room;

import java.util.UUID;

public interface RoomService {
    Room findByIdRoom(UUID roomId);

    Room createRoomInHotel(UUID hotelId, Room room);

    Room updateRoom(UUID roomId, Room room);

    void deleteRoom(UUID roomId);
}
