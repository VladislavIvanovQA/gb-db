package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Buyer;

import java.util.Collections;

@Repository
@Transactional
@RequiredArgsConstructor
public class HibernateBuyerDao implements BuyerDao {
    private final SessionFactory sessionFactory;

    @Override
    public Iterable<Buyer> findAll() {
        return Collections.unmodifiableList(sessionFactory.getCurrentSession().createQuery("from Buyer m").list());
    }

    @Override
    public Buyer findById(Long id) {
        return sessionFactory.getCurrentSession().get(Buyer.class, id);
    }

    @Override
    public Buyer save(Buyer buyer) {
        sessionFactory.getCurrentSession().saveOrUpdate(buyer);
        return buyer;
    }
}
