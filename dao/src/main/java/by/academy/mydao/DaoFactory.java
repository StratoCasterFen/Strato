package by.academy.mydao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory<Connection> {

	public interface DaoCreator<Connection> {
		public GenericDao create(Connection connection);
	}

	public Connection getConnection() throws DaoException, SQLException;

	public GenericDao getDao(Connection connection, Class dtoClass) throws DaoException;

}
