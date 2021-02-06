package com.example.demo.core.entity;

import com.example.demo.core.entity.enums.ReservationStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "RESERVATION")
//@Data
@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer adults;

    @Column(name = "children")
    private Integer children;

    @Column(name = "reservation_time")
    @CreatedDate    //TODO: 적합하지 않음
    private LocalDateTime reservationTime;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;


    public void cancelReservation() {
        this.status = ReservationStatus.CANCELED;
    }

    public int getTotalNumberOfPeople() {
        //TODO: not null 체크..
        return adults + children;
    }

}