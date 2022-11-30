package com.example.demo1.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ICoreCRUDService<E, K> {
    List<E> findAll(HttpServletRequest request);

    E findById(HttpServletRequest request);

    boolean save(HttpServletRequest request);

    boolean deleteById(HttpServletRequest request);
}
