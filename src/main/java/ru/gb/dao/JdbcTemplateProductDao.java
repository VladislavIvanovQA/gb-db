package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

//@Component
@RequiredArgsConstructor
public class JdbcTemplateProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public String findTitleById(Long id) {
        return jdbcTemplate.queryForObject("SELECT name FROM product where id = ?", String.class, id);
    }
}
