package os.consumer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

    private static final String url = "jdbc:postgresql://localhost:5432/rootdb";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connectionDb = null;

    private JdbcUtils() {
    }

    public static Connection initPostgreConnection() {
        if (connectionDb == null) {
            try {
                connectionDb = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connectionDb;
    }

    public static Connection getConnectionDb() {
        return connectionDb;
    }

    public static void closeConnection() {
        try {
            connectionDb.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
