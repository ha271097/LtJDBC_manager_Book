package service.loaisach;

import model.Loaisach;

import java.sql.SQLException;
import java.util.List;

public interface ILoaiSachService {
    List<Loaisach> showAllLoaiSach() throws SQLException;
}
