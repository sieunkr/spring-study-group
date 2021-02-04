package com.example.demo.service;

import com.example.demo.core.entity.Hotel;
import com.example.demo.core.entity.Room;
import com.example.demo.core.entity.RoomType;
import com.example.demo.core.entity.enums.RoomStatus;
import com.example.demo.core.repository.HotelRepository;
import com.example.demo.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public void test() {

        //영속성 전이 관련 샘플...TODO:적합한 사례인지...??
        RoomType roomType = roomRepository.getRoomTypeById(1L).orElseThrow();

        Hotel hotel = Hotel.builder().city("dokyo").name("test01").build();

        Room room = Room.builder()
                .roomStatus(RoomStatus.ON)
                .name("test-name")
                .roomType(roomType)
                .hotel(hotel)
                .build();

        roomRepository.save(room);

    }
}