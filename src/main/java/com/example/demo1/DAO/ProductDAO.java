package com.example.demo1.DAO;

import com.example.demo1.connection.MyConnection;
import com.example.demo1.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;
    private final String SELECT_ALL_PRODUCTS = "select * from product;";
    private final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?;";
    private final String INSERT_PRODUCT = "insert into product(name, price, quantity) value (?,?,?);";
    private final String UPDATE_PRODUCT = "update product set name = ?, price = ?, quantity = ? where id = ?;";
    private final String DELETE_PRODUCT = "delete from product where id = ?;";
    private final String SELECT_PRODUCT_BY_NAME = "select * from product where name like ?;";

    public ProductDAO() {
        connection = MyConnection.getConnection();
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = Long.parseLong(resultSet.getString("id"));
                String name = resultSet.getString("name");
                Double price = Double.parseDouble(resultSet.getString("price"));
                Integer quantity = Integer.parseInt(resultSet.getString("quantity"));
                products.add(new Product(id, name, price, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product findProductById(Long id) {
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                Integer quantity = resultSet.getInt("quantity");
                return new Product(id, name, price, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createProduct(Product product) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProduct(Product product) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setLong(4, product.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduct(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_PRODUCT)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> findAllByNameContaining(String nameSearch) {
        List<Product> products = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_PRODUCT_BY_NAME)) {
            preparedStatement.setString(1, "%" + nameSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = Long.parseLong(resultSet.getString("id"));
                String name = resultSet.getString("name");
                Double price = Double.parseDouble(resultSet.getString("price"));
                Integer quantity = Integer.parseInt(resultSet.getString("quantity"));
                products.add(new Product(id, name, price, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
