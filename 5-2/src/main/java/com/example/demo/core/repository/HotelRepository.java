package com.example.demo.core.repository;

import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    //void save(Hotel hotel);
}
