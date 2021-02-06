package com.example.demo.core.entity;

import com.example.demo.core.entity.constant.ColumnLength;
import com.example.demo.core.entity.enums.RoomStatus;
import com.example.demo.core.entity.enums.RoomType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ROOM")
@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @EmbeddedId
    private RoomId roomId;

    @NotNull
    @Column(name = "name", length = ColumnLength.VARCHAR_NAME)
    private String name;

    //@NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    //@ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_status")
    private RoomStatus roomStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "room_type")
    private RoomType roomType;


    //TODO: 네이밍...
    public boolean verifyPeopleCount(final int adult, final int children) {
        return this.roomType.getMaxPeople() >= adult + children;
    }
}