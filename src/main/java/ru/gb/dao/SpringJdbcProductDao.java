package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import ru.gb.entity.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//@Component
@RequiredArgsConstructor
public class SpringJdbcProductDao implements ProductDao {

    private final DataSource dataSource;

    @Override
    public Iterable<Product> findAll() {
        Set<Product> result = new HashSet<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final Product product = Product.builder()
                        .id(resultSet.getLong("id"))
                        .title(resultSet.getString("title"))
                        .cost(resultSet.getBigDecimal("cost"))
                        .manufactureDate(LocalDate.parse(resultSet.getString("manufacture_date")))
                        .build();
                result.add(product);
            }
            statement.close();
        } catch (SQLException e) {

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return result;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public String findTitleById(Long id) {
        return null;
    }
}
