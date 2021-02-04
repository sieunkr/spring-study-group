package com.example.demo.core.repository;

import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.Room;
import com.example.demo.core.entity.RoomType;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {

    List<Room> findAll();
    Optional<Room> findById(long id);
    void save(Room room);


    Optional<RoomType> getRoomTypeById(long id);
}
