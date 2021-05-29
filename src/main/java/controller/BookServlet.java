package controller;

import model.Book;
import model.Loaisach;
import service.book.BookService;
import service.book.IBookService;
import service.loaisach.ILoaiSachService;
import service.loaisach.LoaisachService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BookServlet", value = "/home")
public class BookServlet extends HttpServlet {
    IBookService bookService = new BookService();
    ILoaiSachService loaiSachService = new LoaisachService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) action = "";
        try {
            switch (action){
                case "create":
                    showFormCreate(request,response);
                    break;
                case "edit":
                    showFormEdit(request,response);
                    break;
            default:
                    showAllBook(request,response);
                break;
            }
        } catch (SQLException throwables) {
        throwables.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        request.setAttribute("listLS", loaiSachService.showAllLoaiSach());
        request.setAttribute("oldBook", bookService.findByID(id));
        dispatcher.forward(request,response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        request.setAttribute("listLS", loaiSachService.showAllLoaiSach());
        dispatcher.forward(request,response);
    }

    private void showAllBook(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("listBook", bookService.showAllBook());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action){
            case "create":
                    saveBook(request,response);
                break;
                case "edit":
                    editBook(request,response);
                    break;
            }
        } catch (SQLException throwables) {
        throwables.printStackTrace();
        }
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        Loaisach loaisach = new Loaisach(Integer.parseInt(request.getParameter("loaisach")));

        bookService.updateBook(new Book(id,name,price,loaisach));

        showAllBook(request,response);
    }

    private void saveBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        Loaisach loaisach = new Loaisach(Integer.parseInt(request.getParameter("loaisach")));

        bookService.saveNewBook(new Book(name,price,loaisach));

        showAllBook(request,response);
    }

}
