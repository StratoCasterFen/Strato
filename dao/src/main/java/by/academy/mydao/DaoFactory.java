package by.academy.mydao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory<C> {

	public interface DaoCreator<C> {
		public GenericDao create(C connection);
	}

	public C getConnection() throws DaoException, SQLException;

	public GenericDao getDao(C connection, Class dtoClass) throws DaoException;

}
