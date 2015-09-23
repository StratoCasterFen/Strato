package by.academy.cfg;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;

public class DBConnection {

	private DataSource dataSource;

	public DBConnection() {
		try {

			InitialContext context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentroom");

		} catch (NamingException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.FATAL, null, ex);
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.FATAL, null, ex);
		}
		return conn;
	}

}
