package com.example.demo.provider;

import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.Reservation;
import com.example.demo.core.entity.RoomId;
import com.example.demo.core.repository.ReservationRepository;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
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

    @Override
    public List<Reservation> findAllByRoomId(RoomId roomId) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reservation> criteriaQuery = builder.createQuery(Reservation.class);

        Root<Reservation> queryRoot = criteriaQuery.from(Reservation.class);

        criteriaQuery.select(queryRoot);
        criteriaQuery.where(builder.equal(queryRoot.get("room_id"), roomId.getId()));

        TypedQuery<Reservation> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
