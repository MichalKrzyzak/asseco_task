package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorImpl implements DBConnector {
    private Connection conn = null;

    public Connection getConnection() throws SQLException {
        if (conn == null) {
            //todo do uzupełnienia informacje dot. połączenia z bazą
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:port:service", "", "");
        }
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
