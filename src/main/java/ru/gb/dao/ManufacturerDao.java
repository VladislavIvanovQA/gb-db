package ru.gb.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entity.Manufacturer;


public interface ManufacturerDao extends JpaRepository<Manufacturer, Long> {
}
