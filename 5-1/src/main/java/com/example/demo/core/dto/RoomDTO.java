package com.example.demo.core.dto;

import com.example.demo.core.entity.Room;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomDTO {

    private long id;
    private long hotelId;
    private String roomType;
    private String roomStatus;

    public static RoomDTO of(Room room) {

        return RoomDTO.builder()
                .id(room.getRoomId().getId())
                .hotelId(room.getHotel().getId())
                .roomType(room.getRoomType().getName())
                .roomStatus(room.getRoomStatus().getName())
                .build();
    }
}