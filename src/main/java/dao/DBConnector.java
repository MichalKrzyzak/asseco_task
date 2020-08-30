package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnector {

    void closeConnection();

    Connection getConnection() throws SQLException;
}
