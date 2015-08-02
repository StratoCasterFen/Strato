package by.academy.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import by.academy.domain.User;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;
import by.academy.mydao.GenericDao;
import by.academy.mysql.ConnectionPool;



public class MySqlDaoFactory implements DaoFactory<Connection> {
	
	private Map<Class, DaoCreator> creators;

	public Connection getConnection() throws DaoException, SQLException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		return connectionPool.getConnection();
	}
	
	public GenericDao getDao(Connection connection, Class dtoClass) throws DaoException {
		DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new DaoException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create(connection);
	}
	
	public MySqlDaoFactory() {

		creators = new HashMap<Class, DaoCreator>();
		creators.put(User.class, new DaoCreator<Connection>() {
			@Override
			public GenericDao create(Connection connection) {
				return new MySqlUserDao(MySqlDaoFactory.this, connection);
			}
		});
	}
}
