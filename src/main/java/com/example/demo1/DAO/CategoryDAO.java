package com.example.demo1.DAO;

import com.example.demo1.connection.MyConnection;
import com.example.demo1.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final Connection connection;
    private final String SELECT_ALL_CATEGORIES = "select * from category;";
    private final String SELECT_CATEGORY_BY_ID = "select * from category where id = ?;";

    public CategoryDAO() {
        connection = MyConnection.getConnection();
    }

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(SELECT_ALL_CATEGORIES)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                categories.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Category findCategoryById(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_CATEGORY_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long idDb = resultSet.getLong("id");
                String name = resultSet.getString("name");
                return new Category(idDb, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
