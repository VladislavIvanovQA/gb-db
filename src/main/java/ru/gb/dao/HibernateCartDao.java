package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Cart;

@RequiredArgsConstructor
//@Repository
public class HibernateCartDao implements CartDao {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional
    public Cart save(Cart cart) {
        sessionFactory.getCurrentSession().saveOrUpdate(cart);
        return cart;
    }
}
