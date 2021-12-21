package ru.gb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {
}
