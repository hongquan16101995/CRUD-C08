package com.example.demo1.controller;

import com.example.demo1.model.Category;
import com.example.demo1.model.Product;
import com.example.demo1.service.impl.ProductServiceImpl;
import com.example.demo1.service.impl.ProductServiceImpl2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductCategoryServlet", value = "/pcs")
public class ProductCategoryServlet extends HttpServlet {
    private ProductServiceImpl2 productService;

    @Override
    public void init() {
        productService = new ProductServiceImpl2();
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
            case "create":
                createForm(request, response);
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        request.setAttribute("products", productService.findAll(request));
        requestDispatcher.forward(request, response);
    }

    private void displayDetailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/detail.jsp");
        request.setAttribute("product", productService.findById(request));
        requestDispatcher.forward(request, response);
    }

    private void displaySearchProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        request.setAttribute("products", productService.findByNameContaining(request));
        requestDispatcher.forward(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = productService.findCategories();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("categories", categories);
        requestDispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Long categoryId = Long.parseLong(request.getParameter("category"));
        productService.save(request);
        response.sendRedirect("http://localhost:8080/pcs");
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/update.jsp");
        request.setAttribute("product", productService.findById(request));
        request.setAttribute("categories", productService.findCategories());
        requestDispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Long categoryId = Long.parseLong(request.getParameter("category"));
        productService.save(request);
        response.sendRedirect("http://localhost:8080/pcs");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        productService.deleteById(request);
        response.sendRedirect("http://localhost:8080/pcs");
    }
}
