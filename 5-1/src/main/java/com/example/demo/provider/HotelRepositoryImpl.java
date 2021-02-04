package com.example.demo.provider;

import com.example.demo.core.entity.Hotel;
import com.example.demo.core.repository.HotelRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Hotel hotel) {
        entityManager.persist(hotel);
    }
}
