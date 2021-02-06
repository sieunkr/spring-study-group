package com.example.demo.provider;

import com.example.demo.core.entity.Reservation;
import com.example.demo.core.repository.ReservationRepository;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Reservation reservation) {
        throw new NotYetImplementedException();
    }

    @Override
    public Optional<Reservation> findById(long id) {
        Reservation reservation = entityManager.find(Reservation.class, id);
        return Optional.ofNullable(reservation);
    }
}
