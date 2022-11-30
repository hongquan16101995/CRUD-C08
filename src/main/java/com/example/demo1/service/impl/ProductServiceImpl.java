package com.example.demo1.service.impl;

import com.example.demo1.DAO.ProductDAO;
import com.example.demo1.model.Product;
import com.example.demo1.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private final ProductDAO productDAO;

    public ProductServiceImpl() {
        productDAO = new ProductDAO();
    }

    @Override
    public List<Product> findAll(HttpServletRequest request) {
        return productDAO.findAll();
    }

    @Override
    public Product findById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return productDAO.findProductById(id);
    }

    @Override
    public boolean save(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        if (id == null) {
            return productDAO.createProduct(new Product(name, price, quantity));
        } else {
            return productDAO.updateProduct(new Product(Long.parseLong(id),name,price, quantity));
        }
    }

    @Override
    public boolean deleteById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return productDAO.deleteProduct(id);
    }

    @Override
    public List<Product> findByNameContaining(HttpServletRequest request) {
        String name = request.getParameter("search");
        return productDAO.findAllByNameContaining(name);
    }
}
