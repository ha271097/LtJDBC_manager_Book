package service.loaisach;

import model.Loaisach;
import service.JDBCBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaisachService implements ILoaiSachService {
    public static final String SHOW_ALL_LOAISACH = "SELECT * FROM loaisach;";
    Connection connection = JDBCBook.getConnection();
    @Override
    public List<Loaisach> showAllLoaiSach() throws SQLException {
        List<Loaisach> listLoaiSach= new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(SHOW_ALL_LOAISACH);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("loaisach_id");
            String nameBook = resultSet.getString("name");
            listLoaiSach.add(new Loaisach(id,nameBook));
        }
        return listLoaiSach;
    }
}
