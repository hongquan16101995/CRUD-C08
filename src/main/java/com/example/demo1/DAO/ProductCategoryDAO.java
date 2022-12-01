package com.example.demo1.DAO;

import com.example.demo1.connection.MyConnection;
import com.example.demo1.model.Category;
import com.example.demo1.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDAO {
    private final Connection connection;
    private final CategoryDAO categoryDAO;
    private final String SELECT_ALL_PRODUCTS = "select * from product;";
    private final String INSERT_PRODUCTS = "insert into product(name, price, quantity, category_id)" +
            "value (?,?,?,?);";

    public ProductCategoryDAO() {
        connection = MyConnection.getConnection();
        categoryDAO = new CategoryDAO();
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                Integer quantity = resultSet.getInt("quantity");
                Long categoryId = resultSet.getLong("category_id");
                Category category = categoryDAO.findCategoryById(categoryId);
                products.add(new Product(id, name, price, quantity, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean createProduct(Product product) {
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_PRODUCTS)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setLong(4, product.getCategory().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}