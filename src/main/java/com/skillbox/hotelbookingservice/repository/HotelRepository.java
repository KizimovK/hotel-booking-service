package com.skillbox.hotelbookingservice.repository;

import com.skillbox.hotelbookingservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRepository extends JpaRepository<Hotel, UUID> {
}
