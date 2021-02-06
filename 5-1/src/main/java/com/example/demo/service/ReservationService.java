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

import java.time.LocalDate;
import java.util.List;
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


    @Transactional
    public void makeReservation(ReservationDTO requestReservationDTO) {

        Room room = roomRepository.findById(new RoomId(requestReservationDTO.getRoomId())).orElseThrow();

        if(!room.verifyPeopleCount(requestReservationDTO.getAdults(), requestReservationDTO.getChildren())) {
            throw new RuntimeException("");
        }

        //TODO: 해당 날짜에 예약이 가능한지 확인..


        // 해당 계정이 휴면 계정인지 확인...
        Customer customer = customerRepository.findById(new CustomerId(requestReservationDTO.getCustomerId()))
                .orElseThrow();


        if(!customer.isPossibleReservation()) {
            throw new RuntimeException("");
        }

        
        //TODO: 예약..
        //reservationRepository.save(Reservation.builder().);

        /*
        //해당 날짜에 예약이 되어있는지 확인..(취소 빼고..)
        //없으면 예약 진행..
        if(verifyReservationDate(new RoomId(1L),
                LocalDate.of(2020, 7, 5),
                LocalDate.of(2020, 7, 7))) {

            log.info("test");
        }

         */
    }

    private boolean verifyReservationDate(RoomId roomId, LocalDate checkInDate, LocalDate checkOutDate) {

        //TODO: 구현 해야함...
        List<Reservation> list = reservationRepository.findAllByRoomId(roomId);
        /*
        list.stream().filter(r -> {
            r.getCheckInDate()
        })
        */
        return true;
    }



}