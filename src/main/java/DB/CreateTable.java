package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
public static void crateTableNow(String queryText) {
    String query = queryText;
    try (
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.execute();

    } catch (
            SQLException e) {
        e.printStackTrace();
    }
 }
}
