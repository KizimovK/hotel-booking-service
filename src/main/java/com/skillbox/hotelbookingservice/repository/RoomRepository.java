package com.skillbox.hotelbookingservice.repository;

import com.skillbox.hotelbookingservice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
}
