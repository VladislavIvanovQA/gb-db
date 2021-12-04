package ru.gb.dao;

import ru.gb.entity.Manufacturer;

public interface ManufacturerDao {
    Iterable<Manufacturer> findAll();
    Manufacturer findById(Long id);
    String findNameById(Long id);
    Manufacturer save(Manufacturer manufacturer);
    void deleteById(Long id);
    void delete(Manufacturer manufacturer);
}
