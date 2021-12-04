package ru.gb.dao;

import ru.gb.entity.Product;

import java.util.Collection;

public interface ProductDao {
    Iterable<Product> findAll();
    Product findById();
    Product save(Product product);
    void deleteAll(Collection<Product> products);
}
