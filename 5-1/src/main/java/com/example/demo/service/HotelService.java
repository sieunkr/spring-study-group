package com.example.demo.service;

import com.example.demo.core.entity.Hotel;
import com.example.demo.core.entity.Room;
import com.example.demo.core.entity.enums.RoomStatus;
import com.example.demo.core.entity.enums.RoomType;
import com.example.demo.core.repository.HotelRepository;
import com.example.demo.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    //영속성 전이 관련 샘플...TODO:적합한 사례인지...??
    public void test() {

        Hotel hotel = Hotel.builder()
                .city("new-york")
                .name("test01")
                .roomList(new ArrayList<>())
                .build();

        Room room = Room.builder()
                .roomStatus(RoomStatus.ON)
                .name("test-name")
                .roomType(RoomType.STANDARD)
                .hotel(hotel)
                .build();

        hotel.getRoomList().add(room);

        hotelRepository.save(hotel);

    }
}