package com.example.demo.core.repository;

import com.example.demo.core.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    /*
    List<Room> findAll();
    Optional<Room> findById(long id);
    void save(Room room);

     */
}
