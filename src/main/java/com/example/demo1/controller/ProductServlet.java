package com.example.demo1.controller;

import com.example.demo1.model.Product;
import com.example.demo1.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl productService;

    @Override
    public void init()  {
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
        }
    }

    private void displayListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list-product.jsp");
        request.setAttribute("products", productService.findAll());
        requestDispatcher.forward(request, response);
    }

    private void displayDetailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("detail-product.jsp");
        request.setAttribute("product", productService.findById(id));
        requestDispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        productService.save(new Product(name, price, quantity));
        response.sendRedirect("http://localhost:8080/products");
    }
}
