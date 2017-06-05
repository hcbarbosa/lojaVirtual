package br.com.hcb.lojaVirtual.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/lojaVirtual", "root", "1234");
        return connection;
    }
}
