package ru.gb.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entity.Order;
import ru.gb.entity.Product;

import java.util.List;


public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findByOrdersContaining (Order order, Sort sort);
}
