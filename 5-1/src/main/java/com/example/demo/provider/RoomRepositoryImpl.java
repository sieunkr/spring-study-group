package com.example.demo.provider;

import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.Room;
import com.example.demo.core.entity.RoomType;
import com.example.demo.core.repository.RoomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Room> findAll() {
        return null;
    }

    @Override
    public Optional<Room> findById(long id) {
        Room room = entityManager.find(Room.class, id);
        return Optional.ofNullable(room);
    }

    @Override
    @Transactional
    public void save(Room room) {
        entityManager.persist(room);
    }



    public Optional<RoomType> getRoomTypeById(long id) {
        RoomType type = entityManager.find(RoomType.class, id);
        return Optional.ofNullable(type);
    }
}
