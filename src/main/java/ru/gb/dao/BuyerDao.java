package ru.gb.dao;

import ru.gb.entity.Buyer;
import ru.gb.entity.Product;

import java.util.Collection;

public interface BuyerDao {
    Iterable<Buyer> findAll();
    Buyer findById(Long id);
    Buyer save(Buyer buyer);
}
