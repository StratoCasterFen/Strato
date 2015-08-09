package by.academy.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import by.academy.domain.Criminal;
import by.academy.domain.CriminalEvent;
import by.academy.domain.Role;
import by.academy.domain.User;
import by.academy.domain.UserRole;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;
import by.academy.mydao.GenericDao;
import by.academy.mysql.ConnectionPool;

public class MySqlDaoFactory implements DaoFactory<Connection> {
	
	private Map<Class, DaoCreator> creators;

	public Connection getConnection() {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		try {
			return connectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
				return new MySqlUserDao(connection);
			}
		});
		creators.put(Role.class, new DaoCreator<Connection>() {
			@Override
			public GenericDao create(Connection connection) {
				return new MySqlRoleDao(connection);
			}
		});
		creators.put(UserRole.class, new DaoCreator<Connection>() {
			@Override
			public GenericDao create(Connection connection) {
				return new MySqlUserRoleDao(connection);
			}
		});
		creators.put(Criminal.class, new DaoCreator<Connection>() {
			@Override
			public GenericDao create(Connection connection) {
				return new MySqlCriminalDao(connection);
			}
		});
		creators.put(CriminalEvent.class, new DaoCreator<Connection>() {
			@Override
			public GenericDao create(Connection connection) {
				return new MySqlCriminalEventDao(connection);
			}
		});
	}


}
