package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

//@Component
@RequiredArgsConstructor
public class NamedParameterJdbcTemplateProductDao implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        return namedParameterJdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT id, title, cost, manufacture_date FROM product as p\n" +
                "WHERE p.id = :productId;";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.query(sql, namedParameters, new ProductExtractor());
    }

    @Override
    public String findTitleById(Long id) {
        String sql = "SELECT title FROM product where id = :productId";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);

    }

    private static class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Product.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .cost(rs.getBigDecimal("cost"))
                    .manufactureDate(LocalDate.parse(rs.getString("manufacture_date")))
                    .build();
        }
    }

    private static class ProductExtractor implements ResultSetExtractor<Product> {

        @Override
        public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
            Product product = null;
            while (rs.next()) {
                product = Product.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .cost(rs.getBigDecimal("cost"))
                        .manufactureDate(LocalDate.parse(rs.getString("manufacture_date")))
                        .build();
            }
            return product;
        }
    }
}
