package ru.gb.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entity.Buyer;

public interface BuyerDao extends JpaRepository<Buyer, Long> {

}
