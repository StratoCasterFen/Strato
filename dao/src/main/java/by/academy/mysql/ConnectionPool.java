package by.academy.mysql;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionPool {
    private static ConnectionPool instance;
    private BasicDataSource dataSource;
    private static final String DRIVER 	 = ResourceBundle.getBundle("database").getString("dbDriver");
    private static final String URL 	 = ResourceBundle.getBundle("database").getString("dbUrl");
    private static final String USER 	 = ResourceBundle.getBundle("database").getString("dbUser");
    private static final String PASSWORD = ResourceBundle.getBundle("database").getString("dbPass");

    private ConnectionPool() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection() throws SQLException {
        dataSource.close();
    }
}