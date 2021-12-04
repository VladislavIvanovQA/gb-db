package ru.gb.dao;

import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class OldJdbcProductDao implements ProductDao {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/gb_shop", "root", "root");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Product> findAll() {
        Set<Product> result = new HashSet<>();

        Connection connection = null;

        try {
            connection = getConnection();
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
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
        return null;
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
