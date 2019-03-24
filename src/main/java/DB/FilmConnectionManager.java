package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FilmConnectionManager {

    public static Connection getConnection() throws SQLException {

        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC",
                        "film","film");
    }
}