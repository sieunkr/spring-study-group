package com.example.demo.core.repository;

import com.example.demo.core.entity.Reservation;
import com.example.demo.core.entity.RoomId;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    void save(Reservation reservation);
    Optional<Reservation> findById(long id);
    List<Reservation> findAllByRoomId(RoomId roomId);
}