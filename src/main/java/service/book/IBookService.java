package service.book;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookService {
    List<Book> showAllBook() throws SQLException;

    void saveNewBook(Book book) throws SQLException;

    Book findByID(int id) throws SQLException;

    void updateBook(Book book) throws SQLException;
}
