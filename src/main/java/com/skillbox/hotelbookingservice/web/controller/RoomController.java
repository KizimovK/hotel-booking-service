package com.skillbox.hotelbookingservice.web.controller;

import com.skillbox.hotelbookingservice.dto.request.UpsertRoomRequest;
import com.skillbox.hotelbookingservice.dto.response.RoomResponse;
import com.skillbox.hotelbookingservice.mapper.RoomMapper;
import com.skillbox.hotelbookingservice.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse findByIdRoom(@PathVariable("id") UUID roomId) {
        return roomMapper.toRoomResponse(roomService.findByIdRoom(roomId));
    }

    @PostMapping("/{hotelId}/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomResponse insertRoomInHotel(@PathVariable UUID hotelId,
                                          @RequestBody @Valid UpsertRoomRequest request) {
        return roomMapper.toRoomResponse(
                roomService.createRoomInHotel(hotelId, roomMapper.toRoom(request)));
    }

    @PutMapping("/{roomId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public RoomResponse updateRoom(@PathVariable UUID roomId,
                                   @RequestBody UpsertRoomRequest request) {
        return roomMapper.toRoomResponse(roomService.updateRoom(roomId, roomMapper.toRoom(request)));
    }

    @DeleteMapping("/{roomId}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable UUID roomId){
        roomService.deleteRoom(roomId);
    }
}
