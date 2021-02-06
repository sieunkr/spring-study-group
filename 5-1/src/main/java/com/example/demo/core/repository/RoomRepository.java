package com.example.demo.core.repository;

import com.example.demo.core.entity.Room;
import com.example.demo.core.entity.RoomId;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {

    List<Room> findAll();
    Optional<Room> findById(RoomId roomId);
    void save(Room room);
}
