package com.skillbox.hotelbookingservice.mapper;

import com.skillbox.hotelbookingservice.dto.request.UpsertRoomRequest;
import com.skillbox.hotelbookingservice.dto.response.RoomResponse;
import com.skillbox.hotelbookingservice.entity.Room;
import com.skillbox.hotelbookingservice.mapper.delegate.RoomMapperDelegate;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@DecoratedWith(RoomMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {
    RoomResponse toRoomResponse(Room room);

    Room toRoom(UpsertRoomRequest request);
}
