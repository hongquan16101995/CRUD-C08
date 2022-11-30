package com.example.demo1.controller;

import com.example.demo1.model.Product;
import com.example.demo1.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl productService;

    @Override
    public void init() {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "detail":
                displayDetailProduct(request, response);
                break;
            case "update":
                updateForm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                displayListProduct(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "search":
                displaySearchProductList(request, response);
                break;
        }
    }

    private void displayListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list-product.jsp");
        request.setAttribute("products", productService.findAll(request));
        requestDispatcher.forward(request, response);
    }

    private void displayDetailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("detail-product.jsp");
        request.setAttribute("product", productService.findById(request));
        requestDispatcher.forward(request, response);
    }

    private void displaySearchProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list-product.jsp");
        request.setAttribute("products", productService.findByNameContaining(request));
        requestDispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (productService.save(request)) {
            HttpSession session = request.getSession();
            session.setAttribute("message", "Create successfully!");
        }
        response.sendRedirect("http://localhost:8080/products");
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-product.jsp");
        request.setAttribute("product", productService.findById(request));
        requestDispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (productService.save(request)) {
            HttpSession session = request.getSession();
            session.setAttribute("message", "Update successfully!");
        }
        response.sendRedirect("http://localhost:8080/products");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (productService.deleteById(request)) {
            HttpSession session = request.getSession();
            session.setAttribute("message", "Delete successfully!");
        }
        response.sendRedirect("http://localhost:8080/products");
    }
}
