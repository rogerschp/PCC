package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

	public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String dbUrl = "jdbc:mysql://localhost:3306/stocksystem";
            String dbUser = "root";
            String dbPass = "Cathoud.2486";

            return (Connection) DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
	
} 