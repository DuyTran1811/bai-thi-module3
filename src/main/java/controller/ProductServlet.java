package controller;

import mode.Category;
import mode.Product;
import sevice.CategoryService;
import sevice.ICategory;
import sevice.IProductService;
import sevice.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private static final IProductService productService = new ProductService();
    private static final ICategory categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showEdit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;

            default:
                listProduct(request, response);
                break;
        }
    }



    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte id = Byte.parseByte(request.getParameter("id"));
        Product product = productService.getById(id);
        request.setAttribute("pro", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/product");
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list1 = categoryService.getAll();
        request.setAttribute("listca", list1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productService.getAll();
        request.setAttribute("listProduct", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request, response);
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
                search(request, response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte id = Byte.parseByte(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        byte quantity = Byte.parseByte(request.getParameter("quantity"));
        String color = request.getParameter("color");
        byte category_id = Byte.parseByte(request.getParameter("category"));
        productService.update(new Product(id, name, price, quantity, color, category_id));
        response.sendRedirect("/product");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        byte quantity = Byte.parseByte(request.getParameter("quantity"));
        String color = request.getParameter("color");
        byte category_id = Byte.parseByte(request.getParameter("category"));
        productService.insert(new Product(name, price, quantity, color, category_id));
        request.setAttribute("message", "Bạn Đã Thêm Thanh Công ");
        showCreate(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("name");
        List<Product> product = productService.search(search);
        request.setAttribute("listProduct",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request,response);
    }
}
