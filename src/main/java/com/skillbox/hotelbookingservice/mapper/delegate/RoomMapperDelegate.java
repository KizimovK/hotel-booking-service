package com.skillbox.hotelbookingservice.mapper.delegate;

import com.skillbox.hotelbookingservice.dto.response.RoomResponse;
import com.skillbox.hotelbookingservice.entity.Room;
import com.skillbox.hotelbookingservice.mapper.HotelMapper;
import com.skillbox.hotelbookingservice.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RoomMapperDelegate implements RoomMapper {

    @Autowired
    private RoomMapper delegate;
    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public RoomResponse toRoomResponse(Room room) {
        RoomResponse roomResponse = delegate.toRoomResponse(room);
        roomResponse.setHotelResponse(hotelMapper.toHotelResponse(room.getHotel()));
        return roomResponse;
    }
}
