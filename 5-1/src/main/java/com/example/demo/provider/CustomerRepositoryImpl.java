package com.example.demo.provider;

import com.example.demo.core.dto.CustomerDTO;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {


    /*
    TODO: 두 방법의 차이가 무엇인지 정확히 검토하자..
     */
    //private final EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        //JPQL, 오랫만에 사용하는 구문이라서... 확실하지 않음.
        return entityManager.createQuery(
                "SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public Optional<Customer> findById(long id) {
        Customer customer = entityManager.find(Customer.class, id);
        return Optional.ofNullable(customer);
    }

    @Override
    public List<Customer> findByLastName(String name) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);

        Root<Customer> queryRoot = criteriaQuery.from(Customer.class);

        criteriaQuery.select(queryRoot);
        criteriaQuery.where(builder.equal(queryRoot.get("lastName"), name));

        TypedQuery<Customer> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }


    /*
    @Override
    public void save(Customer customer) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

     */


    @Override
    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }
    //모든 트랜잭션 관리는 스프링이 한다. entityManager.getTransaction().begin 에러 발생함..


}
