package service.book;

import model.Book;
import model.Loaisach;
import service.JDBCBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    public static final String SHOW_ALL_BOOK = "SELECT b.book_id as book_id, b.name as book_name, b.price as price, l.name as loaisach_name FROM book b join loaisach l on b.loaisach_id = l.loaisach_id;";
    public static final String SAVE_NEW_BOOK = "INSERT INTO book (name, price,loaisach_id) VALUE (?,?,?);";
    public static final String FIND_BOOK_BY_ID = "SELECT * FROM book where book_id = ?;";
    public static final String UPDATE_BOOK = "UPDATE book SET name =?, price=?, loaisach_id=? WHERE book_id=?;";
    Connection connection = JDBCBook.getConnection();
    @Override
    public List<Book> showAllBook() throws SQLException {
        List<Book> listBook = new ArrayList<>();
         PreparedStatement statement = connection.prepareStatement(SHOW_ALL_BOOK);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()){
             int id = resultSet.getInt("book_id");
             String nameBook = resultSet.getString("book_name");
             float price = resultSet.getFloat("price");
             String name = resultSet.getString("loaisach_name");
             Loaisach loaisach = new Loaisach(name);
             listBook.add(new Book(id,nameBook,price,loaisach));
         }
        return listBook;
    }

    @Override
    public void saveNewBook(Book book) throws SQLException {
    PreparedStatement statement = connection.prepareStatement(SAVE_NEW_BOOK);
    statement.setString(1,book.getName());
    statement.setFloat(2,book.getPrice());
    statement.setInt(3,book.getLoaisach().getId());
    statement.executeUpdate();
    }

    @Override
    public Book findByID(int id) throws SQLException {
        Book book = null;
        PreparedStatement statement = connection.prepareStatement(FIND_BOOK_BY_ID);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
//            int id = resultSet.getInt("book_id");
            String name = resultSet.getString("name");
            float price = resultSet.getFloat("price");
            book = new Book(name,price);
        }
        return book;
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
        statement.setString(1,book.getName());
        statement.setFloat(2,book.getPrice());
        statement.setInt(3,book.getLoaisach().getId());
        statement.setInt(4,book.getId());
        statement.executeUpdate();
    }
}
