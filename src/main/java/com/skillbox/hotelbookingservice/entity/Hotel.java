package com.skillbox.hotelbookingservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String announcementTitle;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Float distanceFromCityCenter;

    private Float rating;

    private Integer numberOfRatings;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @Builder.Default
    List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room){
        room.setHotel(this);
        rooms.add(room);
    }
}
