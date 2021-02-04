package com.example.demo.core.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "room_id"))
    )
    private RoomId roomId;

    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "customer_id"))
    )
    private CustomerId customerId;

    @Column(name = "adults")
    private Long adults;

    @Column(name = "children")
    private Long children;

    @Column(name = "reservation_time")
    @CreatedDate    //TODO: 적합하지 않음
    private LocalDateTime reservationTime;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;



}