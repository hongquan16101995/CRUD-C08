package com.example.demo1.service;

import com.example.demo1.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IProductService extends ICoreCRUDService<Product, Long> {
    List<Product> findByNameContaining(HttpServletRequest request);
}
