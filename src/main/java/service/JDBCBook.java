package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCBook {
    private static Connection connection;

    public static final String URL = "jdbc:mysql://localhost:3306/data_book";

    public static final String USER = "root";

    public static final String PASSWORD = "quangha97";

    public static Connection getConnection() {
        if (connection == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
            } catch (SQLException throwables) {

            }
        }
        return connection;
    }
}
