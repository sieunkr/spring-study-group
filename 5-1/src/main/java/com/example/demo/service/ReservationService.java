package com.example.demo.service;

import com.example.demo.core.dto.ReservationDTO;
import com.example.demo.core.entity.*;
import com.example.demo.core.repository.CustomerRepository;
import com.example.demo.core.repository.ReservationRepository;
import com.example.demo.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    public ReservationDTO findById(long id) {
        return reservationRepository.findById(id).map(reservation -> {

            //TODO: 복잡도 높음...
            Customer customer = customerRepository.findById(reservation.getCustomerId())
                 .orElseThrow();
            Room room = roomRepository.findById(reservation.getRoomId())
                 .orElseThrow();
            return ReservationDTO.of(reservation, room, customer);
        }).orElse(ReservationDTO.empty());
    }

    @Transactional
    public void cancelReservation(long id) {
        //reservationRepository.findById(id).ifPresent(reservation -> reservation.setStatus(ReservationStatus.CANCELED));
        reservationRepository.findById(id).ifPresentOrElse(Reservation::cancelReservation,
                () -> { throw new RuntimeException("");}); //TODO: global exception...
    }
}