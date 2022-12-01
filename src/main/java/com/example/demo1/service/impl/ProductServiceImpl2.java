package com.example.demo1.service.impl;

import com.example.demo1.DAO.CategoryDAO;
import com.example.demo1.DAO.ProductCategoryDAO;
import com.example.demo1.model.Category;
import com.example.demo1.model.Product;
import com.example.demo1.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl2 implements IProductService {
    private static ArrayList<Product> products;
    private static ArrayList<Category> categories;
    private static Long INDEX;

    private ProductCategoryDAO productCategoryDAO;
    private CategoryDAO categoryDAO;

    public ProductServiceImpl2() {
        productCategoryDAO = new ProductCategoryDAO();
        categoryDAO = new CategoryDAO();
    }

    static {
        categories = new ArrayList<>();
        categories.add(new Category(1L, "Honda"));
        categories.add(new Category(2L, "Toyota"));
        categories.add(new Category(3L, "BMW"));

        products = new ArrayList<>();
        products.add(new Product(1L, "Civic", 1234567D, 20, categories.get(0)));
        products.add(new Product(2L, "City", 1034567D, 30, categories.get(0)));
        products.add(new Product(3L, "X7", 7777777D, 77, categories.get(2)));
        INDEX = products.get(products.size() - 1).getId();
    }

    @Override
    public List<Product> findAll(HttpServletRequest request) {
        return productCategoryDAO.findAll();
    }

    public List<Category> findCategories() {
        return categoryDAO.findAll();
    }

    public Category findCategoryById(HttpServletRequest request) {
//        for (Category c : categories) {
//            if (c.getId().equals(id)) {
//                return c;
//            }
//        }
        return null;
    }

    @Override
    public Product findById(HttpServletRequest request) {
//        for (Product p : products) {
//            if (p.getId().equals(id)) {
//                return p;
//            }
//        }
        return null;
    }

    @Override
    public boolean save(HttpServletRequest request) {
        String productId = request.getParameter("id");
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Long categoryId = Long.parseLong(request.getParameter("category"));
        if (productId == null) {
            return productCategoryDAO.createProduct(new Product(name, price,
                    quantity, categoryDAO.findCategoryById(categoryId)));
        }
//        else {
//            int index = products.indexOf(findById(product.getId()));
//            products.set(index, product);
//        }
        return false;
    }

    @Override
    public boolean deleteById(HttpServletRequest request) {
//        products.remove(findById(id));
        return false;
    }

    @Override
    public List<Product> findByNameContaining(HttpServletRequest request) {
//        List<Product> productSearch = new ArrayList<>();
//        for (Product product : products) {
//            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
//                productSearch.add(product);
//            }
//        }
//        return productSearch;
        return null;
    }
}
