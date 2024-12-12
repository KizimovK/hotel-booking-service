package com.skillbox.hotelbookingservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int maxCapacity;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "unavailable_dates",
            joinColumns = @JoinColumn(name = "room_id"))
    @Column(name = "dates", nullable = false)
    @Builder.Default
    List<Instant> unavailableDates;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
