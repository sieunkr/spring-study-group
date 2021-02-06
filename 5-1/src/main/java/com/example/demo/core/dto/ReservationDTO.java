package com.example.demo.core.dto;

import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.Reservation;
import com.example.demo.core.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

    private long id;
    private String hotel;
    private String roomType;
    private long adults;
    private long children;
    private long total;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String fullName;
    private String phone;
    private String email;
    private String status;

    //TODO: 깔끔하지가 않음... 좋은 방법 없는지? CQRS 패턴으로 개선하는 방향이 어떤지?
    public static ReservationDTO of(Reservation reservation, Room room, Customer customer) {

        return ReservationDTO.builder()
                .id(reservation.getId())
                .hotel(room.getHotel().getName())
                .roomType(room.getRoomType().name())
                .adults(reservation.getAdults())
                .children(reservation.getChildren())
                .total(reservation.getTotalNumberOfPeople())
                .checkInDate(reservation.getCheckInDate())
                .checkOutDate(reservation.getCheckOutDate())
                .fullName(customer.getFullName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .status(reservation.getStatus().name())
                .build();
    }

    public static ReservationDTO empty() {
        return ReservationDTO.builder().build();
    }

}
