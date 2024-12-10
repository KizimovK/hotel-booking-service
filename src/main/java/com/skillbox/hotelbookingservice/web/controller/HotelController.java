package com.skillbox.hotelbookingservice.web.controller;

import com.skillbox.hotelbookingservice.dto.request.PaginationRequest;
import com.skillbox.hotelbookingservice.dto.request.UpsertHotelRequest;
import com.skillbox.hotelbookingservice.dto.response.HotelResponse;
import com.skillbox.hotelbookingservice.mapper.HotelMapper;
import com.skillbox.hotelbookingservice.service.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotel")
public class HotelController {

    private final HotelMapper hotelMapper;
    private final HotelService hotelService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HotelResponse> findAllHotel(@Valid PaginationRequest paginationRequest) {
        return hotelService.findAllHotel(paginationRequest.pageRequest()).stream()
                .map(hotelMapper::toHotelResponse)
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HotelResponse findByIdHotel(@PathVariable("id") UUID hotelId) {
        return hotelMapper.toHotelResponse(hotelService.findByIdHotel(hotelId));
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public HotelResponse insertNewHotel(@RequestBody @Valid UpsertHotelRequest request) {
        return hotelMapper.toHotelResponse(hotelService.createHotel(hotelMapper.toHotel(request)));
    }

    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public HotelResponse updateHotel(@PathVariable("id") UUID hotelId,
                                     @RequestBody UpsertHotelRequest request) {
        return hotelMapper.toHotelResponse(hotelService.updateHotel(hotelId, hotelMapper.toHotel(request)));
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHotel(@PathVariable("id") UUID hotelId) {
        hotelService.deleteHotel(hotelId);
    }

}
