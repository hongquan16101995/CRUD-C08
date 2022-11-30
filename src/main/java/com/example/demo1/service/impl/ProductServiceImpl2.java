package com.example.demo1.service.impl;

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
//        return products;
        return null;
    }

    public List<Category> findCategories() {
        return categories;
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
//        if (product.getId() == null) {
//            product.setId(++INDEX);
//            products.add(product);
//        } else {
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
