package com.example.demo.service;

import com.example.demo.core.dto.RoomDTO;
import com.example.demo.core.entity.Room;
import com.example.demo.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomDTO findById(long id) {
        return roomRepository.findById(id).map(RoomDTO::of)
                .orElseThrow();
    }

    public void save(Room room) {
        roomRepository.save(room);
    }


    public void test() {
        /* 테스트 코드..
        Hotel hotel = Hotel.builder().city("dokyo").name("test01").build();

        Room room = Room.builder()
                .roomStatus(RoomStatus.ON)
                .roomType(roomRepository.getRoomTypeById(1L).orElseThrow())
                .hotel(hotel)
                .build();

        roomRepository.save(room);
         */

        /*
        roomRepository.findById(1).ifPresent(room -> {
            room.getHotel().setName("테스트");
            roomRepository.save(room);
        });

         */
    }
}