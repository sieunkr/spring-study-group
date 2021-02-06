package com.example.demo.core.repository;

import com.example.demo.core.entity.Reservation;

import java.util.Optional;

public interface ReservationRepository {

    void save(Reservation reservation);
    Optional<Reservation> findById(long id);
}